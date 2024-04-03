import { Link } from "react-router-dom";

const Header = () => {
    return (
        <header class="p-3 text-bg-dark">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"></svg>
                    </a>

                    {/* TO DO :: 로그인 상태값에 따라 분기 처리 */}
                    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <li><Link to="/" class="nav-link px-2 text-secondary">Home</Link></li>
                        <li><Link to="/user/modify"  class="nav-link px-2 text-white">MyPage</Link></li>
                        <li><Link to="/cart"  class="nav-link px-2 text-white">Cart</Link></li>
                        <li><Link to="/order/create"  class="nav-link px-2 text-white">Order</Link></li>
                        <li><Link to="/order"  class="nav-link px-2 text-white">MyOrder</Link></li>
                    </ul>

                    <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                        <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search" />
                    </form>

                    <div class="text-end">
                        <Link to="/user/login" class="btn btn-outline-light me-2">Sign-in</Link>
                        <Link to="/user/regist" class="btn btn-warning">Sign-up</Link>
                    </div>
                </div>
            </div>
        </header>
    );
}

const Footer = () => {
    return (
        <footer class="py-3 my-4">
            {/* TO DO :: 로그인 상태값에 따라 분기 처리 */}
            <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                <li class="nav-item"><Link to="/"  class="nav-link px-2 text-body-secondary">Home</Link></li>
                <li class="nav-item"><Link to="/cart"  class="nav-link px-2 text-body-secondary">Cart</Link></li>
                <li class="nav-item"><Link to="/order/create"  class="nav-link px-2 text-body-secondary">Order</Link></li>
                <li class="nav-item"><Link to="/order"  class="nav-link px-2 text-body-secondary">MyOrder</Link></li>
            </ul>
            <p class="text-center text-body-secondary">© 2024 Company, Inc</p>
        </footer>
    );
}

export { Header, Footer };