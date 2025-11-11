import { APP_INITIALIZER, ApplicationConfig, isDevMode } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideState, provideStore } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { HTTP_INTERCEPTORS, provideHttpClient, withFetch, withInterceptors, withInterceptorsFromDi } from '@angular/common/http';
import { playerFeatureKey, playerReducer } from 'src/app/share/player/store/reducers';
import { KeycloakService } from './auth/keycloak/keycloak.service';
import { HttpTokenInterceptor } from './auth/interceptor/http-token.interceptor';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideStore(),
    provideEffects(),
    provideState(playerFeatureKey, playerReducer),
    provideStoreDevtools({ maxAge: 25, logOnly: !isDevMode() }),
    provideHttpClient(withFetch(), withInterceptorsFromDi()),
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpTokenInterceptor,
      multi:true
    },
    {
      provide: APP_INITIALIZER,
      deps: [KeycloakService],
      useFactory: keycloackFactory, 
      multi: true
    }
]
};

export function keycloackFactory(keycloakService: KeycloakService) {
  return () => keycloakService.init();
}
