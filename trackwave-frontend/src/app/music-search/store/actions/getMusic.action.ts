import { createAction, props } from "@ngrx/store";
import { ActionTypes } from "src/app/music-search/store/actionTypes";
import { MusicRequestInterface } from "src/app/music-search/types/musicRequest.interface";
import { MusicInterface } from "src/app/share/types/music.interface";

export const getMusicAction = createAction(
    ActionTypes.GET_MUSIC,
    props<{musicRequest?: MusicRequestInterface}>()
);

export const getMusicActionSuccess = createAction(
    ActionTypes.GET_MUSIC_SUCCESS,
    props<{musicResponse: MusicInterface[]}>()
);

export const getMusicActionFailure = createAction(
    ActionTypes.GET_MUSIC_FAILURE
);
