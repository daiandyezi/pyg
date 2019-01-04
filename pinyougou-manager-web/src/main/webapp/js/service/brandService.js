//品牌服务
app.service('brandService', function ($http) {
    //读取列表数据绑定到表单
    this.findAll=function () {
        return $http.get('../brand/findAll.do');
    }

    //分页
    this.findPage=function (page, size) {
        return $http.get('../brand/findPage.do?page=' + page + '&size=' + size);
    }

    //增加
    this.add=function (entity) {
        return $http.post('../brand/add.do', entity);
    }

    //修改
    this.update=function (entity) {
        return $http.post('../brand/update.do', entity);
    }

    //findOne
    this.findOne=function (id) {
        return $http.get('../brand/findOne.do?id=' + id);

    }

    //删除
    this.dele=function (selectIds) {
        return $http.get('../brand/delete.do?ids=' + selectIds);
    }

    //搜索
    this.search=function (page, size,searchEntity) {
        return $http.post('../brand/search.do?page=' + page + '&size=' + size,searchEntity)
    }

    //下拉列表数据
    this.selectOptionList=function () {
        return $http.get('../brand/selectOptionList.do');
    }
});