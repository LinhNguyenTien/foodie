import "../../css/mngtDetail.css";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
// import Chart from "../../../components/chart/Chart";
// import Tables from "../../components/table/Table";
// import { Link } from "react-router-dom";


const OrderDetail = () => {
    return (
        <div className="single">
            <Sidebar />
            <div className="singleContainer">
                <Navbar />
                <div className="top">
                    <div className="left">
                        <h1 className="title">Thông tin đơn hàng</h1>
                        <div className="item">

                            <div className="details">
                                <h1 className="itemTitle">01</h1>
                                <div className="detailItem">
                                    <span className="itemKey">Ngày đặt:</span>
                                    <span className="itemValue">02/20/2024</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Tổng tiền:</span>
                                    <span className="itemValue">100000</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Khuyến mãi áp dụng:</span>
                                    <span className="itemValue">5%</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Nhân viên phụ trách:</span>
                                    <span className="itemValue">Ngọc</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Số điện thoại khách hàng:</span>
                                    <span className="itemValue">+1 2345 67 89</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Địa chỉ:</span>
                                    <span className="itemValue">Cần Thơ</span>
                                </div>

                                <div className="detailItem">
                                    <span className="itemKey">Hình thức thanh toán:</span>
                                    <span className="itemValue">Tiền mặt</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Ghi chú:</span>
                                    <span className="itemValue"></span>
                                </div>

                                <div className="detailItem">
                                    <span className="itemKey">Trạng thái:</span>
                                    <span className="itemValue">Đã giao</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* <div className="right">
                        <Chart aspect={3 / 1} title="User Spending ( Last 6 Months)" />
                    </div> */}
                </div>
                <div className="bottom">
                    <h1 className="title">Cập nhật trạng thái đơn hàng</h1>

                </div>
            </div>
        </div>
    );
};

export default OrderDetail;
