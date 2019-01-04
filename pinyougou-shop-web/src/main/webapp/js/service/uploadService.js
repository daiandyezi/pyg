app.service('uploadService',function ($http) {
    //上传文件
    this.uploadFile=function () {
        var formdata=new FormData();//H5上传文件时使用的类
        formdata.append('file',file.files[0]);//file 文件上传框的name files[0]第一个文件上传框
        return $http({
            url:'../upload.do',
            method:'post',
            data:formdata,
            headers:{'Content-Type':undefined},
            transformRequest:angular.identity //将表单进行二进制序列化
        });
    }

});