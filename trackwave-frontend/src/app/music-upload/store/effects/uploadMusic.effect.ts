import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { catchError, map, of, switchMap } from "rxjs";
import { MusicUploadService } from "src/app/music-upload/services/music-upload.service";
import { musicUploadAction, musicUploadActionFailure, musicUploadActionSuccess } from "src/app/music-upload/store/actions/musicUpload.action";

@Injectable()
export class MusicUploadEffect {
    musicUpload$ = createEffect(() =>
        this.actions$.pipe(
            ofType(musicUploadAction),
            switchMap(({musicUploadRequest}) => {
                console.log(musicUploadRequest);
                return this.musicUploadService.uploadMusic(musicUploadRequest).pipe(
                    map(() => {
                        return musicUploadActionSuccess()
                    }),

                    catchError(() => {
                        return of(musicUploadActionFailure())
                    })
                )
            })
        )
    );

    constructor(
        private actions$: Actions,
        private musicUploadService: MusicUploadService
    ) {}
}