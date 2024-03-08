import "../../css/mngtDetail.css";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
// import Chart from "../../../components/chart/Chart";
import Tables from "../../components/table/Table";
import { Link } from "react-router-dom";


const StaffDetail = () => {
    return (
        <div className="single">
            <Sidebar />
            <div className="singleContainer">
                <Navbar />
                <div className="top">
                    <div className="left">
                        <Link to="/staffManagement/editStaff" style={{ textDecoration: "none" }}>
                            <div className="editButton">Chỉnh sửa</div>
                        </Link>
                        <h1 className="title">Thông tin nhân viên</h1>
                        <div className="item">

                            <div className="details">
                                <h1 className="itemTitle">NV1</h1>
                                <div className="detailItem">
                                    <span className="itemKey">Họ:</span>
                                    <span className="itemValue">Nguyễn</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Tên:</span>
                                    <span className="itemValue">Ngọc</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Số điện thoại:</span>
                                    <span className="itemValue">+1 2345 67 89</span>
                                </div>

                                <div className="detailItem">
                                    <span className="itemKey">Trạng thái:</span>
                                    <span className="itemValue">Hoạt động</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* <div className="right">
                        <Chart aspect={3 / 1} title="User Spending ( Last 6 Months)" />
                    </div> */}
                </div>
                <div className="bottom">
                    <h1 className="title">Đơn hàng gần nhất</h1>
                    <Tables />
                </div>
            </div>
        </div>
    );
};

export default StaffDetail;
