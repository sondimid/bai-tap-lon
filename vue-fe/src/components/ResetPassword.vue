<template>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">Đặt Lại Mật Khẩu</h1>
                                        <p class="mb-4">Hãy nhập mật khẩu mới của bạn để tiếp tục.</p>
                                    </div>
                                    <form class="user" @submit.prevent="resetPassword">
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="newPassword" aria-describedby="newPasswordHelp"
                                                placeholder="Nhập mật khẩu mới" v-model="newPassword">
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-user btn-block">
                                            Đặt Lại Mật Khẩu
                                        </button>
                                    </form>
                                    <hr>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div v-if="showSuccessModal" class="modal success-modal">
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
    </div>
</template>
<script>
export default {
    name: 'ResetPassword',
    props: {
        token: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            newPassword: '',
            showSuccessModal: false,
            message: null,
        }
    },
    methods: {
        resetPassword() {
            console.log(this.token)
            console.log(this.newPassword)
            axios.post('http://localhost:8081/reset-password', null, {
                params: {
                    token: this.token,
                    newPassword: this.newPassword
                }
            })
                .then(response => {
                    this.message = "Đổi Mật Khẩu Thành Công"
                    this.showSuccessModal = true;
                })
                .catch(error => {
                    this.message = error.response.data
                    this.showSuccessModal = true
                })

        },
        closeModalSuccess() {
            this.showSuccessModal = false
            this.$router.push('Login')
        }
    },
    mounted() {
        if (!this.token) {
            this.$router.push('Login')
        }
    }
}
</script>
<style>
body {
    background-color: #4e73df;
    background-image: linear-gradient(180deg, #4e73df 10%, #224abe 100%);
    background-size: cover;
}
</style>