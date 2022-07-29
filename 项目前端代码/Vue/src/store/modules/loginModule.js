export default {
    namespaced:true,
    state: {
        userinfo:{
            user:'',
            token:''
        }
    },
    mutations: {
        //设置用户信息
        setuser(state,payload) {
            state.userinfo = payload;
        },
        //清空
        clearUser(state){
            state.userinfor={
                user:'',
                token:''
            }
        }

    },
    getters: {
    },

    actions: {
    },
    modules: {
    }
}