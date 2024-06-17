import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Header, Footer } from './components/00_Layout';
import './utils/layout.css';
import RegistUser from './components/01_RegistUser';
import ModifyUser from './components/02_ModifyUser';
import LoginUser from './components/03_LoginUser';
import Cart from './components/04_Cart';
import Product from './components/05_Product';
import CreateOrder from './components/06_CreateOrder';
import Order from './components/07_Order';
import Admin from './components/98_Admin';
import Error from './components/99_Error';


const Page = () => {
    return (
        <div className='wrapper'>
            <BrowserRouter>
                <div className='contentWrapper'>
                    <Header />
                    <div style={{ position: 'absolute', top: '10%', left: '10%', width: '80%' }}>
                        <Routes>
                            <Route path="/user/regist" element={<RegistUser />}></Route>
                            <Route path="/user/modify" element={<ModifyUser />}></Route>
                            <Route path="/user/login" element={<LoginUser />}></Route>
                            <Route path="/cart" element={<Cart />}></Route>
                            <Route path="/" element={<Product />}></Route>
                            <Route path="/order/create" element={<CreateOrder />}></Route>
                            <Route path="/order" element={<Order />}></Route>
                            <Route path="/admin" element={<Admin />}></Route>
                            <Route path="*" element={<Error />}></Route>
                        </Routes>
                    </div>
                </div>
                <Footer />
            </BrowserRouter>
        </div>
    );
}

export default Page;