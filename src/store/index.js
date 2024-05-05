import { createStore } from 'vuex'
import axios from "axios"
export default createStore({
  state: {
    counter:10,
    user: null,
    userInfo: null,
  },
  getters:{
    getCounter(state){
      return state.counter/*>0?state.counter:"counter小于0，不符合要求"*/
    }
  },
  mutations:{
    addCounter(state,num){
      state.counter+=num
    },
    setUser(state, user) {
      state.user = user;
    },
    setUserInfo(state,userInfo){
      state.userInfo=userInfo;
    }
  },
  //为异步操作做的准备
  actions:{
    asyncAddCounter({commit}){
      axios.get("http://iwenwiki.com/api/generator/list.php")
          .then(res=>{
            console.log("11111111");
            console.log(res.data[0]);
            commit("addCounter",res.data[0])
          })
    }
  }

})
