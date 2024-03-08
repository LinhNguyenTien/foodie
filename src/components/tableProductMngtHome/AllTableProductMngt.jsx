import "../../css/mngtTableHome.css";


//
import { DataGrid } from '@mui/x-data-grid';

//data
import { allProductMngtRows, productMngtColumns } from "../../data/dataProductMngtHome";


import { Link } from "react-router-dom";
import { useState } from "react";



const AllTableProductMngt = () => {

    const [data, setData] = useState(allProductMngtRows);

    const handleDelete = (id) => {
        setData(data.filter((item) => item.id !== id));
    };
    // const handleBlock = (id) => {
    //     
    // };
    const actionColumn = [
        {
            field: "action",
            headerName: "",
            width: 250,
            renderCell: (params) => {
                return (
                    <div className="cellAction">
                        <Link to="/productManagement/test" style={{ textDecoration: "none" }}>
                            <div className="viewButton">Xem chi tiết</div>
                        </Link>

                        {/* if status:Hoạt động => button: Ẩn (Ẩn => Sử dụng) */}
                        <div
                            className="blockButton"
                        //onClick={() => handleBlock(params.row.id)}
                        >
                            Ẩn
                        </div>
                        <div
                            className="deleteButton"
                            onClick={() => handleDelete(params.row.id)}
                        >
                            Xóa
                        </div>
                    </div>
                );
            },
        },
    ];

    return (
        <div className="datatable" >
            <DataGrid className="datagrid"
                rows={data}
                columns={productMngtColumns.concat(actionColumn)}

                initialState={{
                    pagination: {
                        paginationModel: { page: 0, pageSize: 9 },
                    },
                }}
                pageSizeOptions={[9]}
                checkboxSelection
            />
        </div>
    )
}

export default AllTableProductMngt