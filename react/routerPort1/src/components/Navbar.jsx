import React, { useState } from "react";
import { NavLink } from "react-router-dom";
import { FiMenu, FiX } from "react-icons/fi";
import "./Navbar.css";

function Navbar() {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  // isMenuOpen : 모바일 메뉴가 열려있는지 여부(true - 열림, false - 닫힘)
  //네비게이션 항목 목록
  const navItems = [
    { to: "/", label: "Home" },
    { to: "/about", label: "About" },
    { to: "/skills", label: "Skills" },
    { to: "/projects", label: "Projects" },
    { to: "/contact", label: "Contact" },
  ];
  return (
    <nav className="navbar">
      <div className="navbar-container">
        <div className="navbar-content">
          <div className="navbar-logo">
            <span className="logo-text">Portfolio</span>
          </div>
          {/* pc용 nav*/}
          <div className="desktop-nav">
            {navItems.map((item) => (
              <NavLink
                key={item.to}
                to={item.to}
                onClick={() => setIsMenuOpen(false)}
                className={({ isActive }) =>
                  `nav-button ${isActive ? "active" : ""}`
                }
              >
                {/* isActive == true 현재 페이지와 같으면 'active'클래스 추가 */}
                {/* 글자색 보라색 밑줄 보라색 */}
                {item.label}
              </NavLink>
            ))}
          </div>
          {/* isActive - react-router-dom에서 제공 
          현재 주소창 /about 내가 to 속성에 적어준 경로 to="/about" 
          서로 일치하면 리액트 라우터가 isActive를 true로 바꿈
          일치하지 않으면 false 
          <Link> 단순 이동
          <NavLink> 현재 표시 메뉴 표시, 동적 스타일링 
          자동 감지 if(현재 주소 === '/about') */}
          {/* 모바일용 menu button */}
          <button
            onClick={() => setIsMenuOpen(!isMenuOpen)}
            className="mobile-menu-button"
            aria-label="Toggle menu"
          >
            {isMenuOpen ? <FiX size={24} /> : <FiMenu size={24} />}
          </button>
        </div>
        {/* 모바일 네비게이션 */}
        {isMenuOpen && (
          <div className="mobile-nav">
            <div className="mobile-nav-items">
              {navItems.map((item) => (
                <NavLink
                  key={item.to}
                  to={item.to}
                  onClick={() => setIsMenuOpen(false)}
                  className={({ isActive }) =>
                    `mobile-nav-button ${isActive ? "active" : ""}`
                  }
                >
                  {/* isActive == true 현재 페이지와 같으면 'active'클래스 추가 */}
                  {/* 글자색 보라색 밑줄 보라색 */}
                  {item.label}
                </NavLink>
              ))}
            </div>
          </div>
        )}
      </div>
    </nav>
  );
}

export default Navbar;
