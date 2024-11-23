<template>
    <body id="page-top" >

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#" @click="toDashBoardPage">
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
                        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
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

                            <li class="nav-item mx-1 d-flex align-items-center">
                                <button type="button" class="btn btn-primary" @click="addNewMotel">
                                    <i class="fas fa-plus fa-fw"></i>
                                    Thêm nhà trọ mới
                                </button>
                            </li>
                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">{{ userInfo.fullName }} </span>

                                    <img class="img-profile rounded-circle"
                                        :src="this.avatar || '../../assets/img/undraw_profile.svg'">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                    aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#" @click="GetMotel">
                                        <i class="fas fa-building fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Nhà Trọ Đã Đăng
                                    </a>
                                    <div class="dropdown-divider"></div>
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
                            <h1 class="h3 mb-0 text-gray-800">Thông Tin Người Dùng</h1>
                        </div>

                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card mb-4">
                                    <div class="card-body text-center">
                                        <img :src="this.avatar || '../../assets/img/undraw_profile.svg'" alt="avatar"
                                            class="rounded-circle img-fluid" style="width: 89px; border: 2px solid #ddd;">

                                        <h5 class="my-3" style="font-size: 1.2rem; color: #333;">{{ userInfo.fullName }}</h5>
                                        <div class="d-flex justify-content-between mb-2">
                                            <label for="customFile1" class="btn btn-outline-primary" style="cursor: pointer;">Thay Đổi Ảnh Đại
                                                Diện</label>
                                            <input type="file" @change="onFileSelected" class="form-control d-none"
                                                id="customFile1" />
                                            <label class="btn btn-outline-primary" @click="toChangePasswsordPage" style="cursor: pointer;">Đổi
                                                Mật Khẩu</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Họ và Tên</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">{{ userInfo.fullName }}</p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Tên Đăng Nhập</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">{{ userInfo.userName }}</p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Số Điện Thoại</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">{{ userInfo.phoneNumber }}</p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Email</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">{{ userInfo.email }}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
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


    </body>
</template>
<script>
import axios from 'axios';

export default {
    name: 'Profile',
    data() {
        return {
            showModal: false,
            userInfo: {},
            avatar: localStorage.getItem('avatar')
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
        async onFileSelected(event) {
            const file = event.target.files[0];
            if (file) {
                const formData = new FormData();
                formData.append('file', file);
                const response = await axios.post(`http://localhost:8081/upload-avatar/${this.userInfo.id}`, formData, {
                    headers: {
                        'Authorization': `Bearer ${localStorage.getItem('token')}`,
                        'Content-Type': 'multipart/form-data'
                    }
                });
                
                localStorage.setItem('avatar', response.data);
                window.location.reload();
            }
        },
        toChangePasswsordPage(){
            this.$router.push('/change-password')
        },
        addNewMotel() {
            if (this.hasToken) {
                this.$router.push('/add-motel')
            }
            else this.$router.push('/login')
        },
        hasToken() {
            return !!localStorage.getItem('token')
        },
        GetMotel() {
            this.$router.push('/my-motel')
        },
        PostMotel() {
            this.$router.push('/add-motel');
        }

    },
    created() {
        this.getUserInfor();
    }
}

</script>
<style>
/* Sidebar Styles */
.sidebar {
    min-height: 100vh;
    position: fixed;
    transition: all 0.3s;
    width: 240px;
}

.bg-gradient-primary {
    background: linear-gradient(180deg, #4e73df 10%, #224abe 100%);
}

.sidebar-brand {
    padding: 1.5rem 1rem;
    text-decoration: none;
    font-size: 1.2rem;
    font-weight: 800;
    color: white;
}

.sidebar-divider {
    border-top: 1px solid rgba(255, 255, 255, 0.15);
    margin: 1rem 0;
}

.sidebar-heading {
    color: rgba(255, 255, 255, 0.6);
    padding: 0.75rem 1rem;
    font-weight: 800;
    text-transform: uppercase;
}

.nav-item .nav-link {
    padding: 0.75rem 1rem;
    color: rgba(255, 255, 255, 0.8);
    transition: all 0.2s;
}

.nav-item .nav-link:hover {
    color: white;
    background: rgba(255, 255, 255, 0.1);
}

.collapse-inner {
    padding: 0.5rem 0;
    margin: 0 1rem;
    border-radius: 0.35rem;
}

.collapse-item {
    padding: 0.5rem 1rem;
    color: #3a3b45;
    text-decoration: none;
    display: block;
}

.collapse-item:hover {
    background: #eaecf4;
    color: #3a3b45;
}

/* Topbar Styles */
.topbar {
    height: 4.375rem;
    box-shadow: 0 0.15rem 1.75rem 0 rgba(58, 59, 69, 0.15);
}

.navbar-search .input-group {
    width: 300px;
}

.navbar-search input {
    font-size: 0.85rem;
    height: auto;
}

.img-profile {
    height: 2rem;
    width: 2rem;
    object-fit: cover;
}

.topbar-divider {
    width: 0;
    border-right: 1px solid #e3e6f0;
    height: calc(4.375rem - 2rem);
    margin: auto 1rem;
}

/* Content Styles */
#content-wrapper {
    margin-left: 240px;
    min-height: 100vh;
    background-color: #f8f9fc;
}

.container-fluid {
    padding: 1.5rem;
}

/* Card Styles */
.card {
    box-shadow: 0 0.15rem 1.75rem 0 rgba(58, 59, 69, 0.15);
    border: none;
    border-radius: 0.35rem;
}

.card-body {
    padding: 1.25rem;
}

/* Profile Styles */
.rounded-circle {
    border: 3px solid #e3e6f0;
}

.btn-outline-primary {
    border-color: #4e73df;
    color: #4e73df;
}

.btn-outline-primary:hover {
    background-color: #4e73df;
    color: white;
}

/* Utility Classes */
.text-gray-800 {
    color: #5a5c69;
}

.text-gray-600 {
    color: #858796;
}

.text-red-400 {
    color: #e74a3b;
}

/* Responsive Adjustments */
@media (max-width: 768px) {
    #content-wrapper {
        margin-left: 0;
    }

    .sidebar {
        width: 0;
        transform: translateX(-100%);
    }

    .sidebar.show {
        width: 240px;
        transform: translateX(0);
    }

    .navbar-search .input-group {
        width: 100%;
    }
}

/* Modal Styles */
.modal {
    display: block;
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
    border-radius: 0.3rem;
    border: none;
}

.modal-header {
    border-bottom: 1px solid #e3e6f0;
    padding: 1rem;
}

.modal-footer {
    border-top: 1px solid #e3e6f0;
    padding: 1rem;
}

/* Scroll to Top Button */
.scroll-to-top {
    position: fixed;
    right: 1rem;
    bottom: 1rem;
    width: 2.75rem;
    height: 2.75rem;
    background-color: #4e73df;
    border-radius: 0.35rem;
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
    text-decoration: none;
    transition: all 0.2s;
}

.scroll-to-top:hover {
    background-color: #224abe;
}
</style>
