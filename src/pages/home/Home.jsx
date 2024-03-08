import React from 'react';
import "./home.css"
import Sidebar from '../../components/sidebar/Sidebar';
import Navbar from '../../components/navbar/Navbar';
import Widget from '../../components/widget/Widget';
import Featured from '../../components/featured/Featured';
import Chart from '../../components/chart/Chart';
import Tables from '../../components/table/Table';
const Home = () => {
    return (
        <div className='home'>
            <Sidebar />
            <div className="homeContainer">
                <Navbar title="FOODIE-ADMIN" />
                <div className="widgets">
                    <Widget type="product" />
                    <Widget type="order" />
                    <Widget type="comment" />
                    <Widget type="user" />
                </div>
                <div className="charts">
                    <Featured />
                    <Chart />
                </div>

                <div className="listContainer">
                    <div className="listTitle">Đơn hàng gần đây</div>
                    <Tables />
                </div>
            </div>
        </div>
    )
}

export default Home