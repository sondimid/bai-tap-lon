<template>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#"
                    @click="toDashBoardPage">
                    <div class="sidebar-brand-icon rotate-n-20">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-10">Trang Chủ</div>
                </a>

                <hr class="sidebar-divider my-0">

                <div class="sidebar-heading" id="headingSearch" style="font-size:medium">
                    Quản lý tài khoản
                </div>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePrice"
                        aria-expanded="true" aria-controls="collapsePrice">
                        <i class="fas fa-money-bill-wave"></i>
                        <span>Quản Lý Tin</span>
                    </a>
                    <div id="collapsePrice" class="collapse" aria-labelledby="headingPrice"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="#" @click="GetMotel">Tin Đã Đăng</a>
                            <a class="collapse-item" href="#" @click="GetMotelMarked">Tin Đã Đánh Dấu</a>
                            <a class="collapse-item" href="#" @click="PostMotel">Đăng Tin</a>
                        </div>
                    </div>
                </li>
            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->
                        <form
                            class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small"
                                    placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">
                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">{{
                                        userInfo.userName }} </span>

                                    <img class="img-profile rounded-circle"
                                        :src="this.avatar || '../../assets/img/undraw_profile.svg'">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                    aria-labelledby="userDropdown">
                                    <a class="dropdown-item" @click="openLogoutModal" style="cursor: pointer;">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-red-400"></i>
                                        Logout
                                    </a>

                                </div>
                            </li>
                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Đổi Mật Khẩu</h1>
                        </div>

                        <form @submit.prevent="changePassword">
                            <div class="mb-3 row">
                                <label for="exampleInputEmail1" class="form-label col-12 col-md-2">Mật Khẩu Hiện
                                    Tại</label>
                                <div class="col-12 col-md-4">
                                    <input type="password" class="form-control" id="exampleInputEmail1"
                                        v-model="passwordData.currentPassword" aria-describedby="emailHelp" required>

                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="exampleInputPassword1" class="form-label col-12 col-md-2">Mật Khẩu
                                    Mới</label>
                                <div class="col-12 col-md-4">
                                    <input type="password" class="form-control" id="exampleInputPassword1"
                                        v-model="passwordData.newPassword" required>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="exampleInputPassword2" class="form-label col-12 col-md-2">Nhập Lại Mật Khẩu
                                    Mới</label>
                                <div class="col-12 col-md-4">
                                    <input type="password" class="form-control" id="exampleInputPassword2"
                                        v-model="passwordData.retypePassword" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <button type="submit" class="btn btn-primary ml-auto d-block">Đổi Mật Khẩu</button>
                                </div>
                            </div>
                        </form>


                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->

                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->


        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal" tabindex="-1" v-if="showModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Đăng Xuất</h5>
                    </div>
                    <div class="modal-body">
                        <p>Bạn Có Muốn Đăng Xuất?</p>
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal"
                            @click=closeModal>Hủy</button>
                        <button type="button" class="btn btn-danger " data-bs-dismiss="modal" @click=LogoutUser>Đăng
                            Xuất</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal" v-if="showModalChangePassword" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
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
                            @click="closeModalChangePassword">
                            OK
                        </button>
                    </div>

                </div>
            </div>
        </div>

    </body>
</template>

<script>
import axios from 'axios'
export default {
    name: 'ChangePassword',
    data() {
        return {
            showModal: false,
            userInfo: {},
            avatar: localStorage.getItem('avatar'),
            passwordData: {
                currentPassword: '',
                newPassword: '',
                retypePassword: '',
            },
            titleModal: '',
            messageModal: '',
            showModalChangePassword: false

        };
    },
    methods: {
        async toDashBoardPage() {
            this.$router.push('/').then(() => {
                window.location.reload();
            });
        },
        async clearDataAndRedirect(route) {
            localStorage.clear();
            this.resetData();

            this.$router.push(route).then(() => {
                window.location.reload();
            });
        },
        openLogoutModal() {
            this.showModal = true;
        },
        closeModal() {
            this.showModal = false;
        },
        LogoutUser() {
            this.showModal = false;
            localStorage.clear()
            this.$router.push('/login')
        },
        async getUserInfor() {
            this.userInfo = JSON.parse(localStorage.getItem('userInfor'));
            console.log(this.userInfo)
        },
        async changePassword() {
            console.log(this.passwordData)
            try {
                const response = await axios.post('http://localhost:8081/change-password', this.passwordData, {
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${localStorage.getItem('token')}`
                    }
                });

                if (response.status === 202) {
                    this.isSuccess = true
                    this.titleModal = 'Thành Công';
                    this.messageModal = 'Đổi Mật Khẩu Thành Công';
                } else {
                    this.isSuccess = false
                    this.titleModal = 'Thất Bại';
                    this.messageModal = response.data ;
                }

                this.showModalChangePassword = true; 
            } catch (error) {
                console.error(error);
                this.titleModal = 'Thất Bại';
                this.messageModal = error.response.data;
                this.showModalChangePassword = true;
            }
        },
        closeModalChangePassword() {
            this.showModalChangePassword = false
        }
    },
    created() {
        this.getUserInfor();
    }
}
</script>

<style></style>