import { createReducer, on } from "@ngrx/store";
import { musicSelectAction } from "src/app/share/player/store/actions/musicSelect.action";
import { PlayerStateInterface } from "src/app/share/player/types/playerState.interface";

const initialState: PlayerStateInterface = {
    selectedMusic: null
}

export const playerFeatureKey: string = "player";

export const playerReducer = createReducer(
    initialState,
    on(
        musicSelectAction,
        (state, action): PlayerStateInterface => ({
            ...state,
            selectedMusic: action.selectedMusic
        })
    )
);