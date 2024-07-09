import { Routes } from '@angular/router';
import { MusicSearchComponent } from './music-search/components/music-search/music-search.component';
import { provideState } from '@ngrx/store';
import { musicSearchFeatureKey, musicSearchReducer } from 'src/app/music-search/store/reducers';
import { provideEffects } from '@ngrx/effects';
import { GetMusicListEffect } from 'src/app/music-search/store/effects/getMusicList.effect';
import { provideHttpClient } from '@angular/common/http';

export const routes: Routes = [
    {
        path: 'music-search',
        component: MusicSearchComponent,
        providers: [
            provideState(musicSearchFeatureKey, musicSearchReducer),
            provideEffects(GetMusicListEffect),
        ]
    }
];
