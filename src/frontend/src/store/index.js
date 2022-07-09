import Vuex from 'vuex';

export default new Vuex.Store({
    state: {
        content: ''
    },
    mutations: {
        changeContent (state, newContent) {
            state.content = newContent;
        }
    }
})