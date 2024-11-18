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

                <div class="sidebar-heading" id="headingSearch" style="font-size: larger;">
                    Quản Lý Tin
                </div>

                <hr class="sidebar-divider">

                <!-- Advanced Search Button at the bottom -->
                <li class="nav-item">
                    <a class="nav-link" href="#" @click="getMotelByNonStatus">
                        <i class="fas fa-search"></i>
                        <span>Nhà Trọ Đang Chờ Duyệt</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#" @click="getAllUsers">
                        <i class="fas fa-search"></i>
                        <span>Danh Sách Người Dùng</span>
                    </a>
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

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                    aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small"
                                                placeholder="Search for..." aria-label="Search"
                                                aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <li class="nav-item mx-1 d-flex align-items-center" v-if="isAdmin">
                                <button type="button" class="btn btn-primary" @click="toDashBoardPage">
                                    <i class="fas fa-sync-alt fa-fw"></i>
                                    Trang Chủ
                                </button>
                            </li>

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow" v-if="hasToken">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">{{
                                        userInfo.fullName }}</span>

                                    <img class="img-profile rounded-circle"
                                        :src="this.avatar || '../../assets/img/undraw_profile.svg'">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                    aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#" @click="toProfilePage">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Thông Tin Cá Nhân
                                    </a>
                                    <a class="dropdown-item" href="#" @click="toMyMotel">
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
                            <button type="button" class="btn btn-sm" v-if="!hasToken" @click="LogoutUser">
                                <i class="bi bi-box-arrow-in-right"></i> Login
                            </button>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid" v-if="openListMotel">

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">{{ namePage }}</h1>
                        </div>

                        <div class="row">
                            <!-- Delete button for selected items -->
                            <div class="col-12 mb-3 d-flex justify-content-end" v-if="selectedMotels.length">
                                <button class="btn btn-primary" @click="openModalClick">
                                    Duyệt Các Nhà Trọ Đã Chọn
                                </button>
                            </div>

                            <!-- Loop through motels -->
                            <div class="row g-4">
                                <div class="col-8" v-for="motel in listMotel" :key="motel.id">
                                    <div class="card" @click="toMotelDetailPage(motel.id)"
                                        @mousedown.stop="handleMouseDown" style="border: none; 
                                    
                   box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1); 
                   transition: all 0.3s ease;
                   cursor: pointer;
                   display: flex;
                   flex-direction: row;
                   border-radius: 12px;
                   overflow: hidden;
                   background: white;
                   height: 220px;">
                                        <div style="position: absolute; 
                top: 10px; 
                left: 10px; 
                z-index: 10;">
                                            <input type="checkbox" :value="motel.id" v-model="selectedMotels" @click.stop
                                                style="width: 18px; 
         height: 18px; 
         cursor: pointer;">
                                        </div>

                                        <!-- Phần hình ảnh bên trái -->
                                        <div style="position: relative; 
            width: 300px; 
            min-width: 300px; 
            height: 220px;"> <!-- Đặt chiều cao cố định -->
                                            <!-- Ảnh chính -->
                                            <img :src="motel.filesDTO && motel.filesDTO[0] ? motel.filesDTO[0].fileUrl : defaultImage"
                                                style="width: 100%; 
                height: 100%; 
                object-fit: contain;" alt="Motel Image">

                                            <!-- Badge VIP -->


                                            <!-- Số lượng ảnh -->
                                            <div style="position: absolute;
                           bottom: 10px;
                           right: 10px;
                           background: rgba(0, 0, 0, 0.6);
                           color: white;
                           padding: 4px 8px;
                           border-radius: 4px;
                           font-size: 12px;">
                                                <i class="fas fa-image"></i> {{ motel.filesDTO ? motel.filesDTO.length :
                                                0
                                                }}
                                            </div>
                                        </div>

                                        <!-- Phần nội dung bên phải -->
                                        <div style="flex: 1;
                        padding: 16px;
                        display: flex;
                        flex-direction: column;">

                                            <!-- Tiêu đề -->
                                            <h5 style="font-size: 18px;
                          font-weight: 500;
                          margin-bottom: 12px;
                          line-height: 1.4;
                          color: #333;">
                                                {{ motel.title }}
                                            </h5>

                                            <!-- Giá và diện tích -->
                                            <div style="display: flex;
                           gap: 16px;
                           margin-bottom: 12px;">
                                                <div style="color: #f43f5e;
                               font-weight: 600;
                               font-size: 18px;">
                                                    {{ formatPrice(motel.price) }} triệu/tháng
                                                </div>
                                                <div style="color: #666;
                               font-size: 16px;">
                                                    {{ motel.area }}m²
                                                </div>
                                            </div>

                                            <!-- Địa chỉ -->
                                            <div style="display: flex;
                           align-items: center;
                           gap: 8px;
                           margin-bottom: 12px;">
                                                <i class="fas fa-map-marker-alt" style="color: #666;"></i>
                                                <span style="color: #666;">{{ motel.district }}</span>
                                            </div>

                                            <!-- Mô tả -->
                                            <p style="color: #666;
                         font-size: 14px;
                         line-height: 1.5;
                         margin-bottom: 12px;
                         display: -webkit-box;
                         -webkit-line-clamp: 2;
                         -webkit-box-orient: vertical;
                         overflow: hidden;">
                                                {{ motel.detail }}
                                            </p>

                                            <!-- Thời gian đăng -->
                                            <div
                                                style="margin-top: auto; font-size: 14px; color: #666; display: flex; align-items: center; gap: 16px;">
                                                <!-- Ngày đăng -->
                                                <div style="display: flex; align-items: center; gap: 8px;">
                                                    <i class="fas fa-clock" style="color: #00b4d8;"></i>
                                                    Ngày Đăng Bài: {{ formatDate(motel.createdAt) }}
                                                </div>
                                                <!-- Ngày chỉnh sửa -->
                                                <div style="display: flex; align-items: center; gap: 8px;">
                                                    <i class="fas fa-edit" style="color: #f43f5e;"></i>
                                                    Ngày Chỉnh Sửa: {{ formatDate(motel.updatedAt) }}
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Nút yêu thích -->
                                        <div style="position: absolute;
                       top: 10px;
                       right: 10px;
                       width: 32px;
                       height: 32px;
                       display: flex;
                       align-items: center;
                       justify-content: center;
                       border-radius: 50%;
                       background: white;
                       box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
                       cursor: pointer;">
                                            <i class="far fa-heart" style="color: #666;"></i>
                                        </div>
                                    </div>
                                    <div style="border-bottom: 2px solid #ddd; margin: 16px 0;"></div>
                                </div>
                            </div>
                        </div>



                    </div>
                    <div class="container-fluid" v-if="openListUser">

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Thông Tin Người Dùng</h1>
                        </div>

                        <div v-for="user in this.listUser" :key="user.id" class="row mb-5">

                            <div class="col-lg-4">
                                <div class="card mb-4">
                                    <div class="card-body text-center">
                                        <img :src="user.fileUrl || '../../assets/img/undraw_profile.svg'" alt="avatar"
                                            class="rounded-circle img-fluid" style="width: 89px;">

                                        <h5 class="my-3">{{ user.fullName }}</h5>
                                        <div class="d-flex justify-content-center mb-2">
                                            <label class="btn btn-outline-primary" @click="getMotelsByUser(user)">Nhà
                                                Trọ Đã Đăng</label>
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
                                                <p class="text-muted mb-0">{{ user.fullName }}</p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Tên Đăng Nhập</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">{{ user.userName }}</p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Số Điện Thoại</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">{{ user.phoneNumber }}</p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Email</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">{{ user.email }}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr
                                style="border: none; height: 2px; background: linear-gradient(to right, transparent, #020, transparent); width: 100%;">
                        </div>
                    </div>
                    <div class="container-fluid" v-if="openMotelUser">
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">{{ namePage }}</h1>
                        </div>
                        <!-- Main Row -->
                        <div class="row">
                            <!-- Motel Listing Section on the Left -->
                            <div class="col-md-8">
                                <div class="row">
                                    <div class="col-md-12 mb-4" v-for="motel in listMotel" :key="motel.id">
                                        <div class="form-check me-3">
                                            <input type="checkbox" class="form-check-input" :value="motel.id"
                                                v-model="selectedMotels">
                                        </div>

                                        <!-- Card link -->
                                        <a href="#" class="card flex-row align-items-center p-3 shadow-sm w-100"
                                            style="text-decoration: none;">
                                            <!-- Image Section -->
                                            <div class="motel-image" style="width: 300px; height: min-content;">
                                                <img :src="motel.filesDTO && motel.filesDTO[0] ? motel.filesDTO[0].fileUrl : defaultImage"
                                                    class="rounded me-3" alt="Profile Image"
                                                    style="object-fit: cover; border-radius: 8px; width: 100%; height: 100%;">
                                            </div>

                                            <!-- Content Section -->
                                            <div class="card-body">
                                                <!-- Title and Price Section -->
                                                <div class="d-flex justify-content-between align-items-center mb-3">
                                                    <h1 class="card-title fw-bold text-primary mb-0"
                                                        style="font-size: 1.5rem;">
                                                        {{ motel.title }}
                                                    </h1>
                                                    <h3 class="text-success fw-bold mb-0" style="font-size: 1.3rem;">
                                                        {{ motel.price }} triệu/tháng
                                                    </h3>
                                                </div>

                                                <!-- Details Section -->
                                                <div class="mb-3">
                                                    <p class="card-text text-muted">{{ motel.detail }}</p>
                                                </div>

                                                <!-- Footer Section -->
                                                <hr class="sidebar-divider">
                                                <div class="text-end fs-4" style="font-size: 24px;">
                                                    <span v-if="motel.status === '0'">Đang chờ duyệt</span>
                                                    <span v-else-if="motel.status === '1'">Đã được duyệt</span>
                                                </div>

                                                <!-- Button to view details -->
                                                <button class="btn btn-primary text-end"
                                                    @click.stop="toMotelDetailPage(motel.id)">
                                                    Xem Chi Tiết
                                                </button>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <!-- User Information Section on the Right -->
                            <div class="col-md-4 rental-info">
                                <div class="retal-info-header">Thông tin người cho thuê</div>
                                <img :src="motelUser.fileUrl || defaultImage" @error="e => e.target.src = defaultImage"
                                    alt="Renter Avatar" class="renter-avatar" />
                                <p><strong>Tên:</strong> {{ motelUser.fullName }}</p>
                                <p><strong>Số điện thoại:</strong> {{ motelUser.phoneNumber }}</p>
                                <div class="button-container">
                                    <button class="contact-button">Chat</button>
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

            <div class="modal" tabindex="-1" v-if="showModalClick">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Xác Nhận</h5>
                        </div>
                        <div class="modal-body">
                            <p>Bạn Có Muốn Duyệt Các Nhà Trọ Đã Chọn ?</p>
                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal"
                                @click=closeModalClick>Hủy</button>
                            <button type="button" class="btn btn-success " data-bs-dismiss="modal"
                                @click="markMotel">OK</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</template>

<script>
import axios from 'axios';
const handleMouseDown = (event) => {
    // Check if the mousedown occurred on the checkbox
    const checkbox = event.currentTarget.querySelector('input[type="checkbox"]')
    if (checkbox && event.target === checkbox) {
        event.preventDefault()
        event.stopPropagation()
    }
}
export default {
    name: 'Admin',
    data() {
        return {
            showModalClick: false,
            showModal: false,
            userInfo: {},
            listMotel: {},
            defaultImage: new URL('../../assets/img/unnamed.png', import.meta.url).href,
            description: null,
            houseNumber: null,
            ward: null,
            district: null,
            province: null,
            areaFrom: null,
            areaTo: null,
            priceFrom: null,
            priceTo: null,
            interior: null,
            type: null,
            detailDescription: null,
            managerName: null,
            phoneNumber: null,
            page: null,
            maxPageItems: null,
            avatar: localStorage.getItem('avatar') || '',
            namePage: 'Trang Quản Trị',
            selectedMotels: [],
            openListMotel: true,
            openListUser: false,
            listUser: {},
            motelUser: {},
        };
    },
    mounted() {
        if (this.hasToken) {
            if (!localStorage.getItem('userInfor')) {
                this.getUserInfo();
            } else {
                this.userInfo = JSON.parse(localStorage.getItem('userInfor'));
            }
        }
        const userInfor = JSON.parse(localStorage.getItem("userInfor"));
        if (!userInfor || userInfor.role !== "ADMIN") {
            this.$router.push("/");
        }
        this.getMotelByNonStatus();
    },
    methods: {
        toMotelDetailPage(id) {
            this.$router.push({ name: 'MotelDetail', params: { id } });
        },
        toProfilePage() {
            this.$router.push('/profile')
        },
        closeModalClick() {
            this.showModalClick = false;
        },
        LogoutUser() {
            this.showModal = false;
            this.clearDataAndRedirect('/login');
        },
        openLogoutModal() {
            this.showModal = true;
        },
        closeModal() {
            this.showModal = false;
        },
        async getUserInfo() {
            const token = localStorage.getItem('token');
            if (token) {
                try {
                    const response = await axios.get('http://localhost:8081/get-infor', {
                        headers: {
                            'Authorization': `Bearer ${token}`
                        }
                    });
                    localStorage.setItem('userInfor', JSON.stringify(response.data));
                    this.userInfo = response.data;
                    if (this.userInfo.fileUrl) {
                        localStorage.setItem('avatar', this.userInfo.fileUrl)
                        this.avatar = this.userInfo.fileUrl
                    }
                    console.log(response.data)
                } catch (error) {
                    console.error('Error fetching user info:', error);
                }
            }
        },
        async getAllMotels() {
            const response = await axios.get('http://localhost:8081/get-all-motels');
            console.log(response);
            this.listMotel = response.data;
        },
        async searchByPrice(priceFrom, priceTo) {
            const data = this.buildSearchData();
            data.priceFrom = priceFrom;
            data.priceTo = priceTo;
            this.search(data);
        },
        async getMotelByNonStatus() {
            const response = await axios.get('http://localhost:8081/admin/get-all-motels-non-status', {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`
                }
            });
            this.listMotel = response.data;
            this.namePage = 'Danh Sách Nhà Trọ Chờ Duyệt'
            this.openListMotel = true;
            this.openListUser = false;
        },
        async searchByArea(areaFrom, areaTo) {
            const data = this.buildSearchData();
            data.areaFrom = areaFrom;
            data.areaTo = areaTo;
            this.search(data);
        },
        async searchByDistrict(district) {
            const data = this.buildSearchData();
            data.district = district;
            this.search(data);
        },
        async search(data) {
            console.log(data);
            const response = await axios.get('http://localhost:8081/search', {
                params: data,
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            console.log(response.data);
            this.listMotel = response.data;
        },
        async markMotel() {
            this.showModalClick = false;
            console.log(this.selectedMotels)
            const token = localStorage.getItem('token');

            const response = await axios.post(`http://localhost:8081/admin/markMotel`, null, {
                params: {
                    selectedMotels: this.selectedMotels.join(',')
                },
                headers: {
                    'Authorization': `Bearer ${token}`,
                }
            });

            if (response.status === 201) {
                window.location.reload();
            }

        },
        async getMotelsByUser(user) {
            const token = localStorage.getItem('token');
            const response = await axios.get(`http://localhost:8081/admin/get-motels-by-user/${user.id}`, {
                headers: {
                    'Authorization': `Bearer ${token}`,
                }
            })
            this.listMotel = response.data
            this.motelUser = user
            console.log(this.listMotel)
            this.namePage = 'Thông Tin Người Đăng'
            this.openListMotel = false;
            this.openListUser = false;
            this.openMotelUser = true;
        },
        buildSearchData() {
            return {
                description: this.description,
                houseNumber: this.houseNumber,
                ward: this.ward,
                district: this.district,
                province: this.province,
                areaFrom: this.areaFrom,
                areaTo: this.areaTo,
                priceFrom: this.priceFrom,
                priceTo: this.priceTo,
                interior: this.interior,
                type: this.type,
                detailDescription: this.detailDescription,
                managerName: this.managerName,
                phoneNumber: this.phoneNumber,
                page: this.page || 1,
                maxPageItems: this.maxPageItems || 10
            };
        },
        async toDashBoardPage() {
            this.$router.push('/')
        },
        clearDataAndRedirect(route) {
            localStorage.clear();
            this.resetData();

            this.$router.push(route).then(() => {
                window.location.reload();
            });
        },
        async getAllUsers() {
            this.openListMotel = false
            const token = localStorage.getItem('token')
            const response = await axios.get('http://localhost:8081/admin/list-user', {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
            this.listUser = response.data
            this.openListUser = true
        },
        toMyMotel() {
            this.$router.push('/my-motel')
        },
        toAdvancedSearchPage() {
            this.$router.push('/advanced-search')
        },
        openModalClick() {
            this.showModalClick = true;
        },
        resetData() {
            this.showModal = false;
            this.userInfo = {};
            this.listMotel = {};
            this.description = null;
            this.houseNumber = null;
            this.ward = null;
            this.district = null;
            this.province = null;
            this.areaFrom = null;
            this.areaTo = null;
            this.priceFrom = null;
            this.priceTo = null;
            this.interior = null;
            this.type = null;
            this.detailDescription = null;
            this.managerName = null;
            this.phoneNumber = null;
            this.page = null;
            this.maxPageItems = null;
        },
        formatPrice(price) {
            return new Intl.NumberFormat('vi-VN').format(price);
        },
        addNewMotel() {
            if (this.hasToken) {
                this.$router.push('/add-motel')
            }
            else this.$router.push('/login')
        },
        formatDate(date) {
            return new Date(date).toLocaleDateString('vi-VN');
        },
    },
    computed: {
        isAdmin() {
            return this.userInfo?.role === 'ADMIN';
        },
        hasToken() {
            return !!localStorage.getItem('token');
        }
    }
};
</script>
<style scoped>

</style>