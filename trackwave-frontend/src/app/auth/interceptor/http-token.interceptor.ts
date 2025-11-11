import { HttpHeaders, type HttpEvent, type HttpHandler, type HttpInterceptor, type HttpInterceptorFn, type HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { KeycloakService } from '../keycloak/keycloak.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpTokenInterceptor implements HttpInterceptor{

  constructor(private keycloakService: KeycloakService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = this.keycloakService.token;
    if (token) {
      let authReq: HttpRequest<any> = req.clone( {
        headers: new HttpHeaders({
          Authorization: `Bearer ${token}`
        })
      });
      console.log(authReq);
      
      return next.handle(authReq);
    }
    return next.handle(req);
  }
  
}
