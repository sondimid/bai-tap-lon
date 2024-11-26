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
                            <a class="collapse-item" href="#" @click="searchByPrice(0, 1)">Dưới 1 triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(1, 2)">Từ 1 triệu đến 2
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(2, 3)">Từ 2 triệu đến 3
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(3, 5)">Từ 3 triệu đến 5
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(5, 7)">Từ 5 triệu đến 7
                                triệu</a>
                            <a class="collapse-item" href="#" @click="searchByPrice(7)">Trên 7 triệu</a>
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
                <hr class="sidebar-divider">

                <!-- Advanced Search Button at the bottom -->
                <li class="nav-item">
                    <a class="nav-link" href="#" @click="showAdvancedSearchModal">
                        <i class="fas fa-search-plus"></i>
                        <span>Tìm Kiếm Nâng Cao</span>
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

                            <li class="nav-item mx-1 d-flex align-items-center">
                                <button type="button" class="btn btn-primary" @click="addNewMotel">
                                    <i class="fas fa-plus fa-fw"></i>
                                    Thêm nhà trọ mới
                                </button>
                            </li>

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow" v-if="hasToken">
                                <a class="nav-link dropdown-toggle" id="userDropdown" role="button"
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
                    <div id="app" class="container mt-5">
                        <h2 class="text-left mb-4">Tìm kiếm nhà trọ theo bán kính</h2>
                        <form @submit.prevent="findByRadius" class="border p-4 rounded shadow-sm mb-5">
                            <!-- Destination Input -->
                            <div class="mb-3">
                                <label for="destination" class="form-label">Địa chỉ</label>
                                <input type="text" id="address" v-model="destination" class="form-control"
                                    placeholder="Trường học, bệnh viện hoặc địa chỉ cụ thể bất kỳ" autocomplete="off">
                                <div id="suggestions" class="suggestions"></div>
                            </div>

                            <!-- Radius Input -->
                            <div class="mb-3">
                                <label for="radius" class="form-label">Bán kính (km)</label>
                                <input type="number" id="radius" v-model="radius" class="form-control"
                                    placeholder="Nhập bán kính tìm kiếm" required>
                            </div>

                            <!-- Submit Button -->
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                            </div>
                        </form>

                        <div class="row g-4">
                            <div class="col-8" v-for="motel in listMotel" :key="motel.id">
                                <div class="card" @click="toMotelDetailPage(motel.id)" style="border: none; 
                   box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1); 
                   transition: all 0.3s ease;
                   cursor: pointer;
                   display: flex;
                   flex-direction: row;
                   border-radius: 12px;
                   overflow: hidden;
                   background: white;
                   height: 240px;">
                                    <div style="position: absolute; 
                top: 10px; 
                left: 10px; 
                z-index: 10;">
                                        <input type="checkbox" :value="motel.id" v-model="selectedMotels" @click.stop
                                            style="width: 20px;  height: 18px;   cursor: pointer;" v-if="isAdmin">
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
                                            <i class="fas fa-image"></i> {{ motel.filesDTO ? motel.filesDTO.length : 0
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
            margin-bottom: 12px; 
            align-items: center;">
                                            <div style="color: #f43f5e; 
                font-weight: 600; 
                font-size: 18px; 
                line-height: 1.2;">
                                                <i class="fa-solid fa-dollar-sign"></i>
                                                {{ formatPrice(motel.price) }} triệu/tháng
                                            </div>
                                            <div style="color: #666; 
                font-size: 16px; 
                line-height: 1.2;">
                                                {{ motel.area }}m²
                                            </div>
                                            <div style="display: flex; 
            align-items: center; 
            gap: 8px; 
            color: #666; 
            font-size: 16px; 
            line-height: 1.2;">
                                                <i class="fas fa-location" style="color: #00b4d8;"></i>
                                                {{ motel.distance }}
                                            </div>
                                        </div>


                                        <!-- Địa chỉ -->
                                        <div style="display: flex;
                           align-items: center;
                           gap: 8px;
                           margin-bottom: 12px;">
                                            <i class="fas fa-map-marker-alt" style="color: red;"></i>
                                            <span style="color: #666;">{{ motel.ward }}, {{ motel.district }}</span>
                                        </div>

                                        <p><strong>{{ motel.type }}</strong> </p>

                                        <!-- Mô tả -->

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



                    <!-- Begin Page Content -->


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
    name: 'FindMotelsByRadius',
    data() {
        return {
            showModal: false,
            userInfo: {},
            listMotel: {},
            defaultImage: new URL('../../assets/img/undraw_profile.svg', import.meta.url).href,
            avatar: localStorage.getItem('avatar') || '',
            destination: null,
            radius: null,
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
        const apiKey = '9Zd3qashu6zFvhgoWz02tjycaK4dH0qEfKlfCogk'; // https://account.goong.io/keys
        const addressInput = document.getElementById('address');
        const suggestionsContainer = document.getElementById('suggestions');
        let sessionToken = crypto.randomUUID();

        function debounce(func, wait) {
            let timeout;
            return function executedFunction(...args) {
                const later = () => {
                    clearTimeout(timeout);
                    func(...args);
                };
                clearTimeout(timeout);
                timeout = setTimeout(later, wait);
            };
        }

        const debouncedSearch = debounce((query) => {
            if (query.length < 2) {
                suggestionsContainer.style.display = 'none';
                return;
            }


            fetch(`https://rsapi.goong.io/Place/AutoComplete?api_key=${apiKey}&input=${encodeURIComponent(query)}&sessiontoken=${sessionToken}`)
                .then(response => response.json())
                .then(data => {
                    if (data.status === 'OK') {
                        suggestionsContainer.innerHTML = '';
                        suggestionsContainer.style.display = 'block';

                        data.predictions.forEach(prediction => {
                            const div = document.createElement('div');
                            div.className = 'suggestion-item';
                            div.textContent = prediction.description;
                            div.addEventListener('click', () => {
                                addressInput.value = prediction.description;
                                this.destination = prediction.description
                                suggestionsContainer.style.display = 'none';

                               
                            });
                            suggestionsContainer.appendChild(div);
                        });
                    }
                })
                .catch(error => console.error('Lỗi:', error));
        }, 300);

        addressInput.addEventListener('input', (e) => debouncedSearch(e.target.value));

        document.addEventListener('click', function (e) {
            if (!suggestionsContainer.contains(e.target) && e.target !== addressInput) {
                suggestionsContainer.style.display = 'none';
            }
        });

       

    },
    methods: {
        toMotelDetailPage(id) {
            this.$router.push({ name: 'MotelDetail', params: { id } });
        },
        toProfilePage() {
            this.$router.push('/profile')
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

        async toDashBoardPage() {
            this.$router.push('/').then(() => {
                window.location.reload();
            });
        },
        clearDataAndRedirect(route) {
            localStorage.clear();
            this.resetData();

            this.$router.push(route).then(() => {
                window.location.reload();
            });
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
        formatPrice(price) {
            return new Intl.NumberFormat('vi-VN').format(price);
        },

        formatDate(date) {
            return new Date(date).toLocaleDateString('vi-VN');
        },

        getStatusBadgeClass(status) {
            switch (status) {
                case 'Đã Được Duyệt':
                case 'Đã Được Duyệt':
                    return 'bg-success';
                case 'Chưa Được Duyệt':
                case 'Chưa Được Duyệt':
                    return 'bg-danger';
                default:
                    return 'bg-secondary';
            }
        },
        toMyMotel() {
            this.$router.push('/my-motel')
        },
        async findByRadius() {
            const response = await axios.get('http://localhost:8081/find-by-radius', {
                params: {
                    destination: this.destination,
                    radius: this.radius
                }
            })
            this.listMotel = response.data
        }
    },
    computed: {
        hasToken() {
            return !!localStorage.getItem('token');
        }
    }
};

</script>
<style scoped>
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
.suggestions {
    position: absolute;
    background: #1a1d24;
    width: 100%;
    max-height: 300px;
    overflow-y: auto;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    border-radius: 8px;
    z-index: 1000;
    display: none;
    margin-top: 3px;
    border: 1px solid #3f4451;
}

.suggestion-item {
    padding: 12px 16px;
    cursor: pointer;
    display: flex;
    align-items: center;
    border-bottom: 1px solid #3f4451;
    transition: all 0.3s ease;
    position: relative;
    overflow: hidden;
    background: #292e3a;
}

.suggestion-item:last-child {
    border-bottom: none;
}

.suggestion-item:before {
    content: "📍";
    margin-right: 10px;
    font-size: 1.1em;
    transition: transform 0.3s ease;
}

.suggestion-item:hover {
    background: #3a4150;
    color: #ffffff;
    padding-left: 24px;
    cursor: text;
}

.suggestion-item:hover:before {
    transform: scale(1.2);
}

.suggestion-item:after {
    content: '';
    position: absolute;
    left: 0;
    top: 0;
    height: 100%;
    width: 4px;
    background: var(--primary);
    transform: scaleY(0);
    transition: transform 0.3s ease;
}

.suggestion-item:hover:after {
    transform: scaleY(1);
}
.suggestions::-webkit-scrollbar {
    width: 8px;
}

.suggestions::-webkit-scrollbar-track {
    background: #1a1d24;
    border-radius: 8px;
}

.suggestions::-webkit-scrollbar-thumb {
    background: #3f4451;
    border-radius: 8px;
}

.suggestions::-webkit-scrollbar-thumb:hover {
    background: #4f5565;
}


</style>