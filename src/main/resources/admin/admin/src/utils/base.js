const base = {
    get() {
        return {
            url : "http://localhost:8080/tourismvue5/",
            name: "tourismvue5",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/tourismvue5/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于springboot的智能旅游规划的设计与实现"
        } 
    }
}
export default base
