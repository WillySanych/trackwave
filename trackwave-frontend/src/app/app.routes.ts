import { Routes } from '@angular/router';
import { MusicSearchComponent } from './music-search/components/music-search/music-search.component';
import { provideState } from '@ngrx/store';
import { musicSearchFeatureKey, musicSearchReducer } from 'src/app/music-search/store/reducers';
import { provideEffects } from '@ngrx/effects';
import { GetMusicListEffect } from 'src/app/music-search/store/effects/getMusicList.effect';
import { provideHttpClient } from '@angular/common/http';
import { MusicUploadComponent } from 'src/app/music-upload/components/music-upload/music-upload.component';
import { musicUploadFeatureKey, musicUploadReducer } from 'src/app/music-upload/store/reducers';
import { MusicUploadEffect } from 'src/app/music-upload/store/effects/uploadMusic.effect';

export const routes: Routes = [
    {
        path: 'music-search',
        component: MusicSearchComponent,
        providers: [
            provideState(musicSearchFeatureKey, musicSearchReducer),
            provideEffects(GetMusicListEffect),
        ]
    },
    {
        path: 'music-upload',
        component: MusicUploadComponent,
        providers: [
            provideState(musicUploadFeatureKey, musicUploadReducer),
            provideEffects(MusicUploadEffect),
        ]
    },
    {
        path: '',
        redirectTo: 'music-search',
        pathMatch: 'full'
    },
    // {
    //     path: '**',
    //     component: NotFound
    // }
];
