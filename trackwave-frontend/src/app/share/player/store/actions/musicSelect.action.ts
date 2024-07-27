import { createAction, props } from "@ngrx/store";
import { ActionTypes } from "src/app/share/player/store/actionTypes";
import { MusicInterface } from "src/app/share/types/music.interface";

export const musicSelectAction = createAction(
    ActionTypes.MUSIC_SELECT,
    props<{selectedMusic: MusicInterface}>()
);