import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { catchError, map, of, switchMap } from "rxjs";
import { MusicSearchService } from "src/app/music-search/services/music-search.service";
import { getMusicAction, getMusicActionFailure, getMusicActionSuccess } from "src/app/music-search/store/actions/getMusic.action";
import { MusicInterface } from "src/app/music-search/types/music.interface";

@Injectable()
export class GetMusicListEffect {
    getMusicList$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getMusicAction),
            switchMap(({musicRequest}) => {
                return this.musicSearchService.getMusic(musicRequest).pipe(
                    map((musicResponse: MusicInterface[]) => {
                        return getMusicActionSuccess({musicResponse});
                    }),

                    catchError(() => {
                        return of(getMusicActionFailure());
                    })
                )
            })
        )
    );

    constructor(
        private actions$: Actions,
        private musicSearchService: MusicSearchService
    ) {}
}