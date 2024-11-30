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
                    <a class="nav-link" href="#" @click="toAdvancedSearchPage">
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
                            <i class="fa fa-bars">
                            </i>
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
                    <form class="container-fluid" @submit.prevent="addMotel">
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">
                                Thêm Nhà Trọ
                            </h1>
                        </div>
                        <fieldset class="border p-3">

                            <!-- Tên toà nhà -->
                            <div class="mb-3 row">
                                <label for="buildingName" class="col-3 col-form-label">Tên Nhà Trọ</label>
                                <div class="col-7">
                                    <input type="text" class="form-control" id="buildingName" v-model="title"
                                        placeholder="Nhập Tên Nhà Trọ" required />
                                </div>
                            </div>

                            <!-- dsfsgdfhhhhhhhhhhhhhhhhhhhhhhhhdfgd -->
                            <div class="mb-3 row">
                                <label for="houseNumber" class="col-3 col-form-label">Địa Chỉ</label>
                                <div class="col-7">
                                    <input type="text" class="form-control" id="address" v-model="address"
                                        placeholder="Địa chỉ" autocomplete="off" required />
                                    <div id="suggestions" class="suggestions"></div>
                                </div>
                            </div>

                           
                            <!-- Diện tích từ - đến -->
                            <div class="mb-3 row">
                                <label class="col-3 col-form-label">Diện tích (m²)</label>
                                <div class="col-7">
                                    <input type="number" class="form-control" id="area" v-model="area"
                                        placeholder="Diện tích " required />
                                </div>

                            </div>

                            <!-- Giá thuê từ - đến -->
                            <div class="mb-3 row">
                                <label class="col-3 col-form-label">Giá thuê (Triệu VND /Tháng)</label>
                                <div class="col-7">
                                    <input type="number" class="form-control" id="price" v-model="price"
                                        placeholder="Giá thuê" required />
                                </div>

                            </div>

                            <!-- Nội thất -->
                            <div class="mb-3 row">
                                <label for="maxPeople" class="col-3 col-form-label">Số Người Ở Tối Đa</label>
                                <div class="col-7">
                                    <input type="number" class="form-control" id="maxPeople" v-model="maxPeople"
                                        placeholder="Số người ở tối đa" required />
                                </div>
                            </div>

                            <!-- Loại hình -->
                            <div class="mb-3 row">
                                <label for="type" class="col-3 col-form-label">Loại hình</label>
                                <div class="col-7">
                                    <input type="text" class="form-control" id="type" v-model="type"
                                        placeholder="Loại hình" required />
                                </div>
                            </div>

                            <!-- Mô tả chi tiết -->
                            <div class="mb-3 row">
                                <label for="detail" class="col-3 col-form-label">Mô tả chi
                                    tiết</label>
                                <div class="col-7">
                                    <textarea class="form-control" id="detail" v-model="detail"
                                        placeholder="Mô tả chi tiết" required></textarea>
                                </div>
                            </div>

                            <div class="mb-3 row">
                                <label for="uploadFile" class="col-3 col-form-label">Hình ảnh</label>
                                <div class="col-7">
                                    <input class="form-control mb-3" type="file" id="formFileMultiple" multiple required
                                        @change="handleFileSelect" ref="fileInput" />

                                    <!-- Preview container -->
                                    <div class="mt-3 d-flex flex-wrap gap-3">
                                        <div v-for="(preview, index) in previews" :key="index"
                                            class="position-relative preview-container" style="width: 150px;">
                                            <img :src="preview.url" :alt="'Preview ' + (index + 1)"
                                                class="img-fluid rounded"
                                                style="height: 150px; object-fit: cover; width: 100%;" />
                                            <button @click="handleDelete(index)"
                                                class="btn btn-danger btn-sm delete-btn" type="button">
                                                <i class="fas fa-times"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Nút Tìm kiếm -->
                            <div class="mb-3 row">
                                <div class="col-12 text-center">
                                    <button type="submit" class="btn btn-primary w-50" style="font-size: 1.25rem;">
                                        Đăng Bài
                                    </button>
                                </div>
                            </div>

                        </fieldset>
                    </form>

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

        <div class="modal" tabindex="-1" v-if="showModalSuccess">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">{{ modalTitle }}</h5>
                    </div>
                    <div class="modal-body">
                        <p>{{ modelMsg }}</p>
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-primary " data-bs-dismiss="modal"
                            @click="closeModalSuccess">Ok</button>
                    </div>
                </div>
            </div>
        </div>

        <div v-if="isLoading" class="loading-overlay">
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden"></span>
            </div>
        </div>

    </body>
</template>

<script>
import axios from 'axios';

export default {
    name: 'AddMotel',
    data() {
        return {
            showModalSuccess: false,
            showModal: false,
            userInfo: {},
            listMotel: {},
            defaultImage: new URL('../../assets/img/undraw_profile.svg', import.meta.url).href,
            title: null,
            houseNumber: null,
            ward: null,
            district: null,
            province: null,
            areaFrom: null,
            areaTo: null,
            priceFrom: null,
            priceTo: null,
            interior: null,
            maxPeople: null,
            detail: null,
            managerName: null,
            phoneNumber: null,
            page: null,
            street: null,
            maxPageItems: null,
            avatar: localStorage.getItem('avatar') || '',
            area: null,
            price: null,
            modalTitle: null,
            modelMsg: null,
            isLoading: false,
            previews: [],
            address: null,
            province: null,
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
                                console.log(prediction.compound)
                                addressInput.value = prediction.description;
                                this.address = prediction.description
                                this.district = prediction.compound.district
                                this.ward = prediction.compound.commune
                                this.province = prediction.compound.province
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
        async searchAdvance() {
            const data = this.buildSearchData();
            console.log(data)
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
        buildSearchData() {
            return {
                title: this.title,
                houseNumber: this.houseNumber,
                ward: this.ward,
                district: this.district,
                province: this.province,
                areaFrom: this.areaFrom,
                areaTo: this.areaTo,
                priceFrom: this.priceFrom,
                priceTo: this.priceTo,
                interior: this.interior,
                max: this.maxPeople,
                detail: this.detail,
                managerName: this.managerName,
                phoneNumber: this.phoneNumber,
                page: this.page || 1,
                maxPageItems: this.maxPageItems || 10
            };
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
        resetData() {
            this.showModal = false;
            this.userInfo = {};
            this.listMotel = {};
            this.title = null;
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
            this.detail = null;
            this.managerName = null;
            this.phoneNumber = null;
            this.page = null;
            this.maxPageItems = null;
        },
        closeModalSuccess() {
            this.showModalSuccess = false;
            window.location.href = '/my-motel'; 
        },
        async addMotel() {
            this.isLoading = true;
            

            const formData = new FormData();

            formData.append('title', this.title);
            formData.append('address', this.address);
            formData.append('province', this.province);
            formData.append('district', this.district);
            formData.append('ward', this.ward);
            formData.append('area', this.area);
            formData.append('price', this.price);
            formData.append('type', this.type);
            formData.append('maxPeople', this.maxPeople);
            formData.append('detail', this.detail);

            const fileImg = document.getElementById('formFileMultiple').files;
            for (let i = 0; i < fileImg.length; i++) {
                formData.append('files', fileImg[i]);
            }
            console.log(formData);
            const response = await axios.post('http://localhost:8081/create', formData, {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`,
                    'Content-Type': 'form-data',
                }
            });
            if (response.status === 201) {
                this.modalTitle = "Thành Công"
            }
            else {
                this.modalTitle = "Thất Bại"
            }
            this.modelMsg = response.data
            this.showModalSuccess = true
            this.isLoading = false
        },
        handleFileSelect(event) {
            const files = Array.from(event.target.files);

            files.forEach(file => {
                const url = URL.createObjectURL(file);
                this.previews.push({
                    file: file,
                    url: url
                });
            });

        },
        handleDelete(index) {
            // Revoke URL của preview
            URL.revokeObjectURL(this.previews[index].url);

            
            this.previews.splice(index, 1);

            
            const dataTransfer = new DataTransfer();

            
            this.previews.forEach(preview => {
                dataTransfer.items.add(preview.file);
            });

            
            this.$refs.fileInput.files = dataTransfer.files;
        },
        getFiles() {
            return this.previews.map(preview => preview.file);
        },
        toAdvancedSearchPage() {
            this.$router.push('/advanced-search')
        },
    },
    beforeDestroy() {
        this.previews.forEach(preview => {
            URL.revokeObjectURL(preview.url);
        });
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

.spinner-border {
    width: 3rem;
    height: 3rem;
}
.preview-container {
    position: relative;
}

.delete-btn {
    position: absolute;
    top: 5px;
    right: 5px;
    padding: 0.25rem 0.5rem;
    opacity: 0;
    transition: opacity 0.2s ease-in-out;
}

.preview-container:hover .delete-btn {
    opacity: 1;
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