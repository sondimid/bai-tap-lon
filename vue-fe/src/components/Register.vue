<template>
    <!-- Modal -->
    <div class="modal" v-if="showModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content slide-down">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">{{ titleModal }} </h5>
                    <button class="close" type="button" @click="closeModal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>{{ messageModal }}</p>
                </div>
                <div class="modal-footer">
                    <button :class="{ 'btn btn-primary': isSuccess, 'btn btn-danger': !isSuccess }" type="button"
                        @click="closeModal">
                        OK
                    </button>
                </div>

            </div>
        </div>
    </div>

    <div class="bg-gradient-primary">
        <div class="container">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Đăng Ký</h1>
                                </div>
                                <form class="user" @submit.prevent="handleRegister">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" v-model="fullName"
                                            aria-describedby="emailHelp" placeholder="Họ và tên">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" v-model="userName"
                                            placeholder="Tên Đăng Nhập" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control form-control-user" v-model="email"
                                            placeholder="Email" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" v-model="phoneNumber"
                                            placeholder="Số Điện Thoại" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user" v-model="password"
                                            placeholder="Mật Khẩu" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user"
                                            v-model="retypePassword" placeholder="Nhập Lại Mật Khẩu" required>
                                    </div>

                                    <button type="submit" class="btn btn-primary btn-user btn-block">Đăng Ký</button>
                                    <hr>
                                    <a href="index.html" class="btn btn-google btn-user btn-block">
                                        <i class="fab fa-google fa-fw"></i> Login with Google
                                    </a>
                                    <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                        <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                    </a>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="forgot-password.html">Quên Mật Khẩu?</a>
                                </div>
                                <div class="text-center">
                                    <a class="small" @click="toLoginPage">Đã Có Tài Khoản, Đăng Nhập Ngay!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'Register',
    data() {
        return {
            fullName: '',
            userName: '',
            email: '',
            phoneNumber: '',
            password: '',
            retypePassword: '',
            messageModal: '',
            titleModal: '',
            showModal: false,
        };
    },
    methods: {
        handleRegister() {
            const data = {
                fullName: this.fullName,
                userName: this.userName,
                email: this.email,
                phoneNumber: this.phoneNumber,
                password: this.password,
                retypePassword: this.retypePassword
            };
            axios.post('http://localhost:8081/register', data, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    this.isSuccess = true;
                    this.titleModal = "Đăng Ký Thành Công"
                    this.messageModal = "Quay Lại Trang Đăng Nhập"
                    this.showModal = true;
                })
                .catch(error => {
                    this.isSuccess = false;
                    this.titleModal = "Đăng Ký Thất Bại"
                    this.messageModal = error.response.data
                    this.showModal = true;
                })
        },
        closeModal() {
            this.showModal = false;
            if (this.isSuccess = true) {
                this.$router.push('/login')
            }
        },
        toLoginPage() {
            this.$router.push('/login')
        }
    }
}
</script>

<style>
.bg-gradient-primary {
    background-color: #4e73df;
    background-image: linear-gradient(180deg, #4e73df, #4e73df);
    background-size: cover;
    min-height: 100vh;
}


html,
body {
    height: 100%;
    margin: 0;
    padding: 0;
}

.container {
    min-height: 100vh;
}

/* Modal styles */
.modal {
    position: fixed;
    z-index: 1050;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;
    display: flex;
    align-items: flex-start;
    justify-content: center;
    animation: fadeIn 0.75s;

}

.modal-dialog {
    max-width: 500px;
    width: 100%;
    margin-top: 20px;

}

.modal-content {
    border-radius: 0.5rem;
    transform: translateY(-50px);

    animation: slideDown 0.5s forwards;

}

@keyframes slideDown {
    from {
        transform: translateY(-50px);
    }

    to {
        transform: translateY(0);
    }
}

@keyframes fadeIn {
    from {
        opacity: 0;
    }

    to {
        opacity: 1;
    }
}
</style>
