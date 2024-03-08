import "../../css/mngtDetail.css";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
// import Chart from "../../../components/chart/Chart";

import { Link } from "react-router-dom";


const ProductDetail = () => {
    return (
        <div className="single">
            <Sidebar />
            <div className="singleContainer">
                <Navbar />
                <div className="top">
                    <div className="left">
                        <Link to="/productManagement/editProduct" style={{ textDecoration: "none" }}>
                            <div className="editButton">Chỉnh sửa</div>
                        </Link>
                        <h1 className="title">Thông tin món ăn</h1>
                        <div className="item">
                            <img
                                src="https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/c/4/c400652c2a03e0-chocolateicecream01.png"
                                alt=""
                                className="itemImg"
                            />
                            <div className="details">
                                <h1 className="itemTitle">Kem Socola</h1>
                                <div className="detailItem">
                                    <span className="itemKey">Giá:</span>
                                    <span className="itemValue">7000</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Phân loại:</span>
                                    <span className="itemValue">Tráng miệng</span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Mô tả:</span>
                                    <span className="itemValue">
                                        Vị socola
                                    </span>
                                </div>
                                <div className="detailItem">
                                    <span className="itemKey">Trạng thái:</span>
                                    <span className="itemValue">Đang bán</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* bảng số liệu bán hàng của món ăn */}
                    {/* <div className="right">
                        <Chart aspect={3 / 1} title="User Spending ( Last 6 Months)" />
                    </div> */}
                </div>
                <div className="bottom">
                    <h1 className="title">Đánh giá</h1>
                    <div className="details">
                        <h1 className="itemTitleCmt">Tên KH</h1>
                        <div className="detailItem">
                            <span className="itemKey">Số sao:</span>
                            <span className="itemValue"></span>
                        </div>
                        <div className="detailItem">
                            <span className="itemKey">Đánh giá:</span>
                            <span className="itemValue"></span>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    );
};

export default ProductDetail;
