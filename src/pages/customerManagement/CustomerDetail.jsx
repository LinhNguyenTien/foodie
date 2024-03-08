import "../../css/mngtDetail.css";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
// import Chart from "../../../components/chart/Chart";
import Tables from "../../components/table/Table";
//import { Link } from "react-router-dom";


const CustomerDetail = () => {
    return (
        <div className="single">
            <Sidebar />
            <div className="singleContainer">
                <Navbar />
                <div className="top">
                    <div className="left">
                        {/* <Link to="/customerManagement/editCustomer" style={{ textDecoration: "none" }}>
                            <div className="editButton">Chỉnh sửa</div>
                        </Link> */}
                        <h1 className="title">Thông tin khách hàng</h1>
                        <div className="item">

                            <div className="details">
                                <h1 className="itemTitle">Jane Doe</h1>
                                <div className="detailItem">
                                    <span className="itemKey">Email:</span>
                                    <span className="itemValue">janedoe@gmail.com</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Số điện thoại:</span>
                                    <span className="itemValue">+1 2345 67 89</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Địa chỉ:</span>
                                    <span className="itemValue">
                                        Elton St. 234 Garden Yd. NewYork
                                    </span>
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

export default CustomerDetail;
