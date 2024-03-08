import Home from "./pages/home/Home";
import Login from "./pages/login/Login";

import CustomerDetail from "./pages/customerManagement/CustomerDetail";

import { BrowserRouter, Routes, Route } from "react-router-dom";

import ChangePassword from "./pages/changePassword/ChangePassword";
import CustomerMngtHome from "./pages/customerManagement/CustomerMngtHome";

import StaffMngHome from "./pages/staffManagement/StaffMngtHome";
import StaffDetail from "./pages/staffManagement/StaffDetail";
import AddStaff from "./pages/staffManagement/AddStaff";
import EditStaff from "./pages/staffManagement/EditStaff";
import DiscountMngtHome from "./pages/discountManagement/DiscountMngtHome";
import DiscountDetail from "./pages/discountManagement/DiscountDetail";
import AddCustomer from "./pages/customerManagement/AddCustomer";
import EditCustomer from "./pages/customerManagement/EditCustomer";
import AddDiscount from "./pages/discountManagement/AddDiscount";
import EditDiscount from "./pages/discountManagement/EditDiscount";
import ProductMngtHome from "./pages/productManagement/ProductMngtHome";
import ProductDetail from "./pages/productManagement/ProductDetail";
import AddProduct from "./pages/productManagement/AddProduct";
import EditProduct from "./pages/productManagement/EditProduct";
import OrderMngtHome from "./pages/orderManagement/OrderMngtHome";
import OrderDetail from "./pages/orderManagement/OrderDetail";
import EditOrder from "./pages/orderManagement/EditOrder";



function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>

          <Route path="/">
            <Route index element={<Home />} />
            <Route path="login" element={<Login />} />

            <Route path="staffManagement">
              <Route index element={<StaffMngHome />} />
              <Route path=":staffId" element={<StaffDetail />} />

              <Route path="addStaff" element={<AddStaff title="Thêm nhân viên" />} />
              <Route path="editStaff" element={<EditStaff title="Chỉnh sửa thông tin nhân viên" />} />
            </Route>

            <Route path="discountManagement">
              <Route index element={<DiscountMngtHome />} />
              <Route path=":discountId" element={<DiscountDetail />} />

              <Route path="addDiscount" element={<AddDiscount title="Thêm khuyến mãi" />} />
              <Route path="editDiscount" element={<EditDiscount title="Chỉnh sửa thông tin khuyến mãi" />} />
            </Route>

            <Route path="customerManagement">
              <Route index element={<CustomerMngtHome />} />
              <Route path=":customerId" element={<CustomerDetail />} />

              <Route path="addCustomer" element={<AddCustomer title="Thêm khách hàng" />} />
              <Route path="editCustomer" element={<EditCustomer title="Chỉnh sửa thông tin khách hàng" />} />
            </Route>

            <Route path="productManagement">
              {/* <Route index element={<User />} /> */}
              <Route index element={<ProductMngtHome />} />
              <Route path=":productId" element={<ProductDetail />} />
              <Route path="addProduct" element={<AddProduct title="Thêm món ăn" />} />
              <Route path="editProduct" element={<EditProduct title="Chỉnh sửa thông tin món ăn" />} />
            </Route>

            <Route path="orderManagement">
              <Route index element={<OrderMngtHome />} />
              <Route path=":orderId" element={<OrderDetail />} />

              {/* <Route path="addDiscount" element={<AddDiscount title="Thêm khuyến mãi" />} /> */}
              <Route path="editOrder" element={<EditOrder title="Chỉnh sửa đơn hàng" />} />
            </Route>

            <Route path="setting">
              <Route path="changePassword" element={<ChangePassword title="Thay đổi mật khẩu" />} />
            </Route>
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
