<template>
    <div class="container">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-10">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">Quên Mật Khẩu?</h1>
                                        <p class="mb-4">Nhập email của bạn ở dưới, chúng tôi sẽ gửi cho bạn một đường
                                            link về mail của bạn để đặt lại mật khẩu!</p>
                                    </div>
                                    <form class="user" @submit.prevent="resetPassword">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user" id="email"
                                                aria-describedby="emailHelp" placeholder="Nhập địa chỉ email"
                                                v-model="email">
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-user btn-block">
                                            Đặt Lại Mật Khẩu
                                        </button>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <router-link to="Register" class="small">Tạo tài khoản mới!</router-link>
                                    </div>
                                    <div class="text-center">
                                        <router-link to="Login" class="small">Đã có tài khoản? Đăng nhập!</router-link>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div v-if="showModalError" class="modal success-modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Thông Báo</h5>
                    </div>
                    <div class="modal-body">
                        <p>{{ message }}</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal"
                            @click=closeModalSuccess>OK</button>
                    </div>
                </div>
            </div>
        </div>
        <div v-if="isLoading" class="loading-overlay">
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    name: 'ForgotPassword',
    data() {
        return {
            email: null,
            message: null,
            showModalError: false,
            isLoading: false,
        }
    },
    methods: {
        async resetPassword() {
            this.isLoading = true
            await axios.post(`http://localhost:8081/forgot-password/${this.email}`)
                .then(response => {
                    this.message = "Yêu cầu đặt lại mật khẩu đã được gửi. Vui lòng kiểm tra email của bạn."
                    this.showModalError = true; 
                })
                .catch(error => {
                    this.message = error.response.data
                    this.showModalError = true
                })
            this.isLoading = false
        },
        closeModalSuccess() {
            this.showModalError = false
        },
    }
}
</script>
<style scoped>
.loading-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 9999;
}
</style>