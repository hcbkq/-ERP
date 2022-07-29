<template>
  <div>
    <el-upload
        class="avatar-uploader"
        action="https://jsonplaceholder.typicode.com/posts/"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload">
      <img v-if="imageUrl" :src="imageUrl" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
    <el-form ref="editform"  :data="tableData.data" label-width="80px">
      <el-form-item label="编号">
        <el-input v-model="editform.cid"></el-input>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="editform.username"></el-input>
      </el-form-item>
      <el-form-item label="性别">
      <el-input v-model="editform.sex"></el-input>
    </el-form-item>
      <el-form-item label="手机">
        <el-input v-model="editform.phone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="editform.email"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">修改</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>


</template>

<script>
import axios from "axios";
import qs from "qs";
export default {
  data() {
    return {
      imageUrl: '',
      tableData:[],
      editform:{
        cid:'123',
        username: '',
        phone: '',
        email: '',
        sex:'',
      }

    };
  },
  methods: {
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    },
    handleEdit() {

      axios.post('http://192.168.1.111:8080/customer/findByCustomers',params,
      ).then((res)=>{
        let stuArr=res.data.data
        //
        this.editform ={
          cid:stuArr[0].cid,
          username:stuArr[0].username,
          phone: stuArr[0].phone,
          email: stuArr[0].email,
          associated:stuArr[0].associated,
          cityName:stuArr[0].cityName,
        }
        //刷新列表信息
        this.getcustomerData()
        //关闭对话框
        this.dialogVisible=false;


      }).catch((res)=>{})

    },
  }

}
</script>

<style scoped>
.el-form-item{

}
avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>