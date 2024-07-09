import { MusicInterface } from "src/app/music-search/types/music.interface";

export interface MusicSearchStateInterface {
    isLoading: boolean,
    musicList: MusicInterface[] | null,
    error: boolean | null
}