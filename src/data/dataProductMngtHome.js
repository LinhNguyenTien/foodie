

export const productMngtColumns = [
    { field: "id", headerName: "ID", width: 90 },
    {
        field: "productName",
        headerName: "Tên",
        width: 230,
        renderCell: (params) => {
            return (
                <div className="cellWithImg">
                    <img className="cellImg" src={params.row.imgLink} alt="avatar" />
                    {params.row.productName}
                </div>
            );
        },
    },
    // { field: 'productName', headerName: 'Tên', width: 180 },
    { field: 'productPrice', headerName: 'Giá', width: 100 },

    {
        field: "category",
        headerName: "Phân loại",
        width: 150,
    },
    {
        field: "discription",
        headerName: "Mô tả",
        width: 250,
    },

    {
        field: "status",
        headerName: "Trạng thái",
        width: 120,
        renderCell: (params) => {
            return (
                <div className={`cellWithStatus ${params.row.status}`}>
                    {params.row.status}
                </div>
            );
        },
    },
];

//temporary data
export const allProductMngtRows = [

    {
        id: 1,
        productName: 'Kem Socola',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/c/4/c400652c2a03e0-chocolateicecream01.png",
        productPrice: "7000",
        category: "Tráng miệng",
        discription: "Vị socola",
        status: "Đang bán",

    },
    {
        id: 2,
        productName: 'Bánh xoài đào',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/p/m/pmp-plated.png",
        productPrice: "10000",
        category: "Tráng miệng",
        discription: "Làm từ bột mì có hương vị xoài",
        status: "Đang bán",
    },
    {
        id: 3,
        productName: '7 UP',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/7/6/76632fe162df44-1.png",
        productPrice: "12000",
        category: "Thức uống",
        discription: "Ly vừa",
        status: "Đang bán",

    },
    {
        id: 4,
        productName: 'Mì ý sốt bò bằm',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/m/_/m__2.png",
        productPrice: "45000",
        category: "Món ăn",
        discription: "Lớn",
        status: "Đang bán",

    },
    {
        id: 5,
        productName: 'Cơm trắng',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/b/3/b3ad51b912e4e5-2mienggaran24.png",
        productPrice: "10000",
        category: "Phần ăn phụ",
        discription: "1 chén",
        status: "Đang bán",

    },
    {
        id: 6,
        productName: 'Khoai tây chiên',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/5/5/5532107fb902fd-1860001_khoaivua21.png",
        productPrice: "20000",
        category: "Phần ăn phụ",
        discription: "Vừa",
        status: "Đã ẩn",

    },

];

export const activeProductMngtRows = [

    {
        id: 1,
        productName: 'Kem Socola',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/c/4/c400652c2a03e0-chocolateicecream01.png",
        productPrice: "7000",
        category: "Tráng miệng",
        discription: "Vị socola",
        status: "Đang bán",

    },
    {
        id: 2,
        productName: 'Bánh xoài đào',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/p/m/pmp-plated.png",
        productPrice: "10000",
        category: "Tráng miệng",
        discription: "Làm từ bột mì có hương vị xoài",
        status: "Đang bán",
    },
    {
        id: 3,
        productName: '7 UP',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/7/6/76632fe162df44-1.png",
        productPrice: "12000",
        category: "Thức uống",
        discription: "Ly vừa",
        status: "Đang bán",

    },
    {
        id: 4,
        productName: 'Mì ý sốt bò bằm',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/m/_/m__2.png",
        productPrice: "45000",
        category: "Món ăn",
        discription: "Lớn",
        status: "Đang bán",

    },
    {
        id: 5,
        productName: 'Cơm trắng',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/b/3/b3ad51b912e4e5-2mienggaran24.png",
        productPrice: "10000",
        category: "Phần ăn phụ",
        discription: "1 chén",
        status: "Đang bán",

    },

];

export const hiddenProductMngtRows = [
    {
        id: 6,
        productName: 'Khoai tây chiên',
        imgLink: "https://jollibee.com.vn/media/catalog/product/cache/9011257231b13517d19d9bae81fd87cc/5/5/5532107fb902fd-1860001_khoaivua21.png",
        productPrice: "20000",
        category: "Phần ăn phụ",
        discription: "Vừa",
        status: "Đã ẩn",

    },

];