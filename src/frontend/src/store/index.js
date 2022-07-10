import Vuex from 'vuex';

export default new Vuex.Store({
    state: {
        content: '',
        isLoadingContent: false,
        activeFile: null
    },
    mutations: {
        changeContent (state, newContent) {
            state.content = newContent;
        },

        changeIsLoadingContent(state, newState) {
            state.isLoadingContent = newState;
        },

        changeActiveFile(state, newState) {
            state.activeFile = newState;
        }
    }
})