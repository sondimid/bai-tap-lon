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
                    Tìm Kiếm Nhanh
                </div>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePrice"
                        aria-expanded="true" aria-controls="collapsePrice">
                        <i class="fas fa-money-bill-wave"></i>
                        <span>Tìm Theo Giá</span>
                    </a>
                    <div id="collapsePrice" class="collapse" aria-labelledby="headingPrice"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="#" @click="searchByPrice(0, 1000)">Dưới 1 triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(1000, 2000)">Từ 1 triệu đến 2
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(2000, 3000)">Từ 2 triệu đến 3
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(3000, 5000)">Từ 3 triệu đến 5
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(5000, 7000)">Từ 5 triệu đến 7
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(7000)">Trên 7 triệu</a>
                        </div>
                    </div>
                </li>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseArea"
                        aria-expanded="true" aria-controls="collapseArea">
                        <i class="fas fa-vector-square"></i>
                        <span>Tìm Theo Diện Tích</span>
                    </a>
                    <div id="collapseArea" class="collapse" aria-labelledby="headingArea"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="#" @click="searchByArea(0, 20)">Dưới 20m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(20, 25)">Từ 20m² đến 25m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(25, 30)">Từ 25m² đến 30m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(30, 35)">Từ 30m² đến 35m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(35, 40)">Từ 35m² đến 40m²</a>
                            <a class="collapse-item" href="#" @click="searchByArea(40)">Trên 40m²</a>
                        </div>
                    </div>
                </li>

                <hr class="sidebar-divider">

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseDistrict"
                        aria-expanded="true" aria-controls="collapseDistrict">
                        <i class="fas fa-fw fa-map-marker-alt"></i>
                        <span>Tìm Theo Quận</span>
                    </a>
                    <div id="collapseDistrict" class="collapse" aria-labelledby="headingDistrict"
                        data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="#" @click="searchByDistrict('Hà Đông')">Hà Đông</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Hoàn Kiếm')">Hoàn Kiếm</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Ba Đình')">Ba Đình</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Đống Đa')">Đống Đa</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Hai Bà Trưng')">Hai Bà Trưng</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Cầu Giấy')">Cầu Giấy</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Tây Hồ')">Tây Hồ</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Thanh Xuân')">Thanh Xuân</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Long Biên')">Long Biên</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Nam Từ Liêm')">Nam Từ Liêm</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Bắc Từ Liêm')">Bắc Từ Liêm</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Gia Lâm')">Gia Lâm</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Sóc Sơn')">Sóc Sơn</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Đông Anh')">Đông Anh</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Thanh Trì')">Thanh Trì</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Hoài Đức')">Hoài Đức</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Mê Linh')">Mê Linh</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Thạch Thất')">Thạch Thất</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Ứng Hòa')">Ứng Hòa</a>
                            <a class="collapse-item" href="#" @click="searchByDistrict('Ba Vì')">Ba Vì</a>
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

                            <!-- Nav Item - Alerts -->
                            

                            <!-- Nav Item - Messages -->
                            

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow" v-if="hasToken">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">{{
                                        userInfo.fullName }}</span>

                                    <img class="img-profile rounded-circle" :src="this.avatar || '../../assets/img/undraw_profile.svg'">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                    aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Settings
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Activity Log
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" @click="openLogoutModal" style="cursor: pointer;">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-red-400"></i>
                                        Logout
                                    </a>

                                </div>
                            </li>
                            <button type="button" class="btn btn-sm" v-if="!hasToken" @click="toLoginPage">
                                <i class="bi bi-box-arrow-in-right"></i> Login
                            </button>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid main-container">
                        <div class="row">
                            <div v-if="motel" class="col-md-8 motel-info">
                                <div class="motel-image-container">
                                    <!-- Hình ảnh -->
                                    <img :src="motel.imageUrl[currentImageIndex]" 
                                        @error="e => e.target.src = defaultImage" 
                                        alt="Motel Image" 
                                        class="motel-image-large" />
                                    
                                    <!-- Các nút điều hướng -->
                                    <div class="image-navigation">
                                        <button @click="previousImage">←</button>
                                        <button @click="nextImage">→</button>
                                    </div>
                                </div>

                                <div class="motel-details">
                                    <h2 class="motel-title">{{ motel.title }}</h2>
                                    <p><strong>Địa chỉ:</strong> {{ motel.address }}</p>
                                    <p style="color:green;"><strong>Giá:</strong> {{ motel.price }} /tháng</p>
                                    <p style="color:black;"><strong>Diện tích:</strong> {{ motel.area }} m²</p>
                                    <p><strong>Chi tiết:</strong> {{ motel.detail }}</p>
                                </div>
                            </div>

                            <div class="col-md-4 rental-info">
                                <div class="retal-info-header">Thông tin người cho thuê</div>
                                <img :src="motel.retalinfo.retalavatar || defaultImage" 
                                    @error="e => e.target.src = defaultImage" 
                                    alt="Renter Avatar" 
                                    class="renter-avatar" />
                                <p><strong>Tên:</strong> {{ motel.retalinfo.retatname }}</p>
                                <p><strong>Số điện thoại:</strong> {{ motel.retalinfo.retalSDT }}</p>
                                <button class="contact-button">Liên hệ ngay</button>
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
                        <button type="button" class="btn btn-danger " data-bs-dismiss="modal" @click=toLoginPage>Đăng
                            Xuất</button>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</template>

<script >
import axios from 'axios';
import listMotel from '../../motels.js';
export default {
    name: 'MotelDetail',
    data() {
        return {
            showModal: false,
            userInfo: {},
            motel: null,
            listMotel,
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
            currentImageIndex: 0,
            avatar : localStorage.getItem('avatar') || ''
        };
    },
    created() {
        const motelId = this.$route.params.id; 
        if (motelId) {
            this.fetchMotelDetail(motelId);  
            console.error('Motel ID is missing');
        }
    },
    mounted() {
        this.getUserInfo();
        const motelId = this.$route.params.id;
        if (motelId) {
            this.fetchMotelDetail(motelId);  
        } else {
            console.error('Motel ID is missing');
        }
    },
    methods: {
        toDashBoardPage() {
            this.resetData();
            this.$router.push('/').then(() => {
                window.location.reload();
            });
        },
        toLoginPage() {
            this.showModal = false;
            localStorage.clear();
            this.$router.push('/login')
        },
        openLogoutModal() {
            this.showModal = true;
        },
        closeModal() {
            this.showModal = false
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
                    console.log(response);
                    this.userInfo = response.data;
                } catch (error) {
                    console.error('Error fetching user info:', error);
                }
            }
        },
         async getAllMotels() {
            this.listMotel=listMotel;
            console.log(this.listMotel);
        },
        async searchByPrice(priceFrom, priceTo) {
            const data = this.createSearchData({ priceFrom, priceTo });
            this.search(data);
        },
        async searchByArea(areaFrom, areaTo) {
            const data = this.createSearchData({ areaFrom, areaTo });
            this.search(data);
        },
        async searchByDistrict(district) {
            const data = this.createSearchData({ district });
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
        fetchMotelDetail(id) {
            const motel = this.listMotel.find(motel => motel.id === id);
            if (motel) {
                this.motel = motel;
                console.log('Motel details:', motel); 
            } else {
                console.error('Không tìm thấy nhà trọ với ID:', id);
                this.motel = {};
            }
        },
        createSearchData(overrides) {
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
                maxPageItems: this.maxPageItems || 10,
                ...overrides
            };
        }, 
        previousImage() {
            if (this.currentImageIndex > 0) {
                this.currentImageIndex--;
            } else {
                this.currentImageIndex = this.motel.imageUrl.length - 1; 
            }
        },
        nextImage() {
            if (this.currentImageIndex < this.motel.imageUrl.length - 1) {
                this.currentImageIndex++;
            } else {
                this.currentImageIndex = 0; 
            }
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
        }
    },

    computed: {
        hasToken() {
            return !!localStorage.getItem('token')
        }
    }
}
</script>

<style scoped>

.main-container {
    margin: 30px 0;
}
/* Phông chữ chung cho trang */
body {
    font-family: 'Roboto', sans-serif; 
    color: #333;
    line-height: 1.6;
}

/* Thông tin nhà trọ */
.motel-info {
    padding: 20px;
}

/* Border cho ảnh motel */
.motel-image-container {
    position: relative; 
    text-align: center;
    margin-bottom: 15px;
    border: 2px solid #ddd;
    border-radius: 8px;
    padding: 10px;
}

.motel-image-large {
    width: 80%;
   
    max-height: 500px;
    border-radius: 8px;
}

.image-navigation {
    position: absolute;
    top: 50%;
    left: 0;
    right: 0;
    transform: translateY(-50%);
    display: flex;
    justify-content: space-between;
    width: 100%; 
}

.image-navigation button {
    background-color: rgba(0, 0, 0, 0.5); 
    color: white;
    border: none;
    padding: 10px;
    font-size: 18px;
    cursor: pointer;
    border-radius: 50%;
    opacity: 0.7;
}
.image-navigation button:hover {
    opacity: 1; 
}
/* Thông tin motel */
.motel-details {
    max-height: 250px; 
    overflow-y: auto; 
    padding: 20px;
    border: 2px solid #ddd;
    border-radius: 8px;
    background-color: #fafafa;
}
.motel-title {
    font-size: 28px; 
    font-weight: bold;
    margin-bottom: 15px;
    color: #055699; 
    text-transform: uppercase; 
}
.motel-details p {
    font-size: 16px; 
    margin-bottom: 12px;
    color: #555; 
}
.motel-details p strong {
    color: #333; 
}
.motel-details p span.price {
    color: #28a745; 
    font-weight: bold;
}

.rental-info {
    background-color: #f8f9fa;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    border: 1px solid #ddd;
    /* Sử dụng flexbox để căn giữa nội dung */
    display: flex;
    flex-direction: column;  
    justify-content: center; 
    align-items: center;     
    height: 100%;           
}
.retal-info-header {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 15px;
    text-align: center;
}
.renter-avatar {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    object-fit: cover;
    margin-bottom: 15px;
}
.rental-info p {
    text-align: center;
    margin-bottom: 10px;
}
.contact-button {
    background-color: #28a745;
    color: white;
    padding: 12px 25px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin-top: 20px; 
    font-size: 16px;
}
.contact-button:hover {
    background-color: #218838;
}


.re__btn {
    font-size: 10px;
    padding: 3px 8px;
    border-radius: 5px;
    transition: all 0.3s ease;
    width: 80px;
    max-width: 100px;
    text-align: center;
    overflow: hidden;
    white-space: nowrap;
}

.re__btn-se-border--md {
    border: 2px solid #3498db;
    background-color: transparent;
}

.re__btn-se-ghost--md {
    color: #3498db;
    background-color: transparent;
}

.login-btn {
    font-weight: bold;
    text-transform: uppercase;
    letter-spacing: 1px;
}

.re__btn:hover {
    background-color: #3498db;
    color: #ffffff;
    transform: scale(1.05);
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.15);
}

.re__btn:active {
    transform: scale(0.98);
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
}

.card {
    display: flex;
    border: 1px solid #dee2e6;
    border-radius: 0.5rem;
    overflow: hidden;
    margin-right: 10px;
}

.card-img-right {
    width: 30%;
    /* Reduced to 30% for a larger card body */
    height: auto;
}

.card-body {
    padding: 4.5rem;
    width: 70%;
}

.card-title {
    margin-bottom: 0.5rem;
}

.card-text {
    color: #6c757d;
}

@media (max-width: 768px) {
    .col-lg-6 {
        flex: 0 0 100%;
        margin-bottom: 1rem;
    }
}
</style>