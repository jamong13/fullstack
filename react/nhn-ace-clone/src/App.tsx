/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import React, { useState } from 'react';
import { 
  ChevronRight, 
  ChevronLeft, 
  Download, 
  ExternalLink, 
  Menu, 
  Globe, 
  Target, 
  Cpu, 
  Users, 
  Database, 
  Monitor, 
  Zap, 
  BarChart3,
  ArrowRight
} from 'lucide-react';
import { motion, AnimatePresence } from 'motion/react';

const NAV_ITEMS = ['Solutions', 'Resources', 'Company'];
const QUICK_LINKS = [
  {
    title: 'DEVELOPMENT GUIDE',
    links: [
      { name: 'Publisher Integration Guide', href: '#' },
      { name: 'ADLIB SDK Integration Guide', href: '#' },
      { name: 'ACETRADER Creative Specifications', href: '#' },
    ]
  },
  {
    title: 'NHN ACE DOWNLOAD',
    links: [
      { name: 'ACE Trader', href: '#', icon: Download },
      { name: 'ACE eXchange', href: '#', icon: Download },
      { name: 'ACE ADLIB', href: '#', icon: Download },
    ]
  },
  {
    title: 'NOTICE',
    content: 'NHN ACE 홈페이지 개편 안내',
    href: '#'
  }
];

const FEATURES = [
  { title: '맞춤형 타겟팅 광고', desc: '광고 목표에 최적화된 타겟팅', icon: Target, color: 'text-red-500' },
  { title: '머신러닝 자동 최적화', desc: '성과 기반 자동 최적화', icon: Cpu, color: 'text-red-500' },
  { title: '실시간 오디언스', desc: '행동기반 실시간 분석', icon: Users, color: 'text-red-500' },
  { title: '최대 규모 양질 데이터', desc: '광범위한 행동 데이터 확보', icon: Database, color: 'text-red-500' },
  { title: '프리미엄 미디어', desc: '검증된 고품질 매체', icon: Monitor, color: 'text-red-500' },
  { title: '정교한 비딩 시스템', desc: '효율 높은 광고 노출 전략', icon: Zap, color: 'text-red-500' },
  { title: '양방향 RTB', desc: '입찰 효율 최적화 구조', icon: BarChart3, color: 'text-red-500' },
];

const INSIGHTS = [
  {
    id: 1,
    title: '6. 앞으로의 영상 광고, ACE Trader와 함께',
    tags: ['#AceTrader', '#크로스디바이스', '#CTV'],
    image: 'https://picsum.photos/seed/ads1/800/600'
  },
  {
    id: 2,
    title: '5. FAST, 새로운 무료 방송의 시대',
    tags: ['#FAST', '#LG채널', '#삼성플러스TV'],
    image: 'https://picsum.photos/seed/ads2/800/600'
  },
  {
    id: 3,
    title: '4. OTT와 CTV의 등장(2) — CTV : 인터넷과 TV, 직접 연결되다',
    tags: ['#connectedTV', '#CTV', '#FAST', '#CTV광고', '#Qtone'],
    image: 'https://picsum.photos/seed/ads3/800/600'
  }
];

const PARTNERS = [
  'https://picsum.photos/seed/p1/200/100?grayscale',
  'https://picsum.photos/seed/p2/200/100?grayscale',
  'https://picsum.photos/seed/p3/200/100?grayscale',
  'https://picsum.photos/seed/p4/200/100?grayscale',
  'https://picsum.photos/seed/p5/200/100?grayscale',
  'https://picsum.photos/seed/p6/200/100?grayscale',
  'https://picsum.photos/seed/p7/200/100?grayscale',
  'https://picsum.photos/seed/p8/200/100?grayscale',
  'https://picsum.photos/seed/p9/200/100?grayscale',
  'https://picsum.photos/seed/p10/200/100?grayscale',
];

export default function App() {
  const [activeTab, setActiveTab] = useState('ACE TRADER');

  return (
    <div className="min-h-screen bg-white font-sans text-gray-900">
      {/* Header */}
      <header className="fixed top-0 left-0 right-0 z-50 bg-white/90 backdrop-blur-sm border-b border-gray-100">
        <div className="max-w-7xl mx-auto px-4 h-20 flex items-center justify-between">
          <div className="flex items-center gap-12">
            <h1 className="text-2xl font-black tracking-tighter flex items-center">
              NHN <span className="text-red-600 ml-1">ACE</span>
            </h1>
            <nav className="hidden md:flex items-center gap-8">
              {NAV_ITEMS.map(item => (
                <a key={item} href="#" className="text-sm font-semibold hover:text-red-600 transition-colors">
                  {item}
                </a>
              ))}
            </nav>
          </div>
          <div className="flex items-center gap-6">
            <button className="flex items-center gap-1 text-xs font-bold uppercase tracking-wider">
              KOR <ChevronRight size={14} />
            </button>
            <button className="p-2">
              <Menu size={24} />
            </button>
          </div>
        </div>
      </header>

      {/* Hero Section */}
      <section className="relative h-[80vh] pt-20 overflow-hidden">
        <div className="absolute inset-0">
          <img 
            src="https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?auto=format&fit=crop&q=80&w=2000" 
            alt="Hero Background" 
            className="w-full h-full object-cover"
            referrerPolicy="no-referrer"
          />
          <div className="absolute inset-0 bg-black/40" />
        </div>
        
        <div className="relative max-w-7xl mx-auto px-4 h-full flex flex-col justify-center text-white">
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.8 }}
          >
            <h2 className="text-4xl md:text-6xl font-bold leading-tight mb-4">
              데이터로 완성하는 마케팅 혁신<br />
              <span className="text-red-500">NHN ACE</span>
            </h2>
            <p className="text-lg md:text-xl opacity-80 max-w-2xl">
              NHN ACE, Accelerating Marketing With Data Intelligence
            </p>
          </motion.div>

          <div className="absolute bottom-12 right-4 flex items-center gap-4">
            <div className="text-sm font-mono">02 / 04</div>
            <div className="flex gap-2">
              <button className="w-10 h-10 rounded-full border border-white/30 flex items-center justify-center hover:bg-white hover:text-black transition-all">
                <ChevronLeft size={20} />
              </button>
              <button className="w-10 h-10 rounded-full border border-white/30 flex items-center justify-center hover:bg-white hover:text-black transition-all">
                <ChevronRight size={20} />
              </button>
            </div>
          </div>
        </div>
      </section>

      {/* Quick Links */}
      <section className="max-w-7xl mx-auto px-4 -mt-20 relative z-10 grid grid-cols-1 md:grid-cols-3 gap-4">
        {QUICK_LINKS.map((card, idx) => (
          <div key={idx} className="bg-white/90 backdrop-blur-md p-8 rounded-xl shadow-2xl border border-white/20 group hover:bg-black hover:text-white transition-all duration-300">
            <h3 className="text-xs font-bold tracking-widest uppercase mb-6 opacity-60">{card.title}</h3>
            {card.links ? (
              <ul className="space-y-3">
                {card.links.map(link => (
                  <li key={link.name}>
                    <a href={link.href} className="text-sm font-medium flex items-center justify-between group-hover:text-white/80">
                      {link.name}
                      {link.icon ? <link.icon size={16} /> : <ExternalLink size={14} className="opacity-40" />}
                    </a>
                  </li>
                ))}
              </ul>
            ) : (
              <a href={card.href} className="text-sm font-medium flex items-center justify-between">
                {card.content}
                <ChevronRight size={16} />
              </a>
            )}
            <div className="mt-8 flex justify-end">
              <div className="w-8 h-8 rounded-full bg-gray-100 group-hover:bg-white/20 flex items-center justify-center">
                <ArrowRight size={16} />
              </div>
            </div>
          </div>
        ))}
      </section>

      {/* Product Showcase */}
      <section className="py-24 bg-gray-50">
        <div className="max-w-7xl mx-auto px-4 text-center">
          <h2 className="text-3xl font-bold mb-16">NEW & BETTER WAY OF Targeting AD!</h2>
          
          <div className="bg-white rounded-3xl shadow-xl overflow-hidden max-w-5xl mx-auto">
            <div className="flex border-b border-gray-100">
              {['ACE TRADER', 'ACE EXCHANGE', 'ACE ADLIB'].map(tab => (
                <button
                  key={tab}
                  onClick={() => setActiveTab(tab)}
                  className={`flex-1 py-6 text-sm font-bold tracking-wider transition-all ${
                    activeTab === tab ? 'text-red-600 border-b-2 border-red-600' : 'text-gray-400 hover:text-gray-600'
                  }`}
                >
                  {tab}
                </button>
              ))}
            </div>
            
            <div className="p-12 md:p-20 flex flex-col md:flex-row items-center gap-16">
              <div className="flex-1 text-left">
                <h3 className="text-4xl font-black mb-6">
                  <span className="text-red-600">ACE</span> TRADER
                </h3>
                <p className="text-gray-600 leading-relaxed mb-8">
                  NHN Trader는 국내 서비스를 제공하는 광고주에 최적화된 플랫폼으로, 웹/앱 광고 서비스를 통해 정교하고 효과적인 타겟팅을 제공합니다. 국내외 전문가들과 함께 다양한 데이터 기반의 분석과 자동화 기능을 통해 최대의 광고 효율을 선사합니다.
                </p>
                <button className="px-8 py-3 bg-black text-white text-sm font-bold rounded-full hover:bg-red-600 transition-all">
                  더 알아보기 →
                </button>
              </div>
              <div className="flex-1 relative">
                <div className="w-64 h-64 mx-auto bg-gray-100 rounded-full flex items-center justify-center">
                  <div className="w-48 h-48 border-4 border-red-500 rounded-full flex items-center justify-center animate-pulse">
                    <Target size={80} className="text-red-500" />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* Features Grid */}
      <section className="py-24">
        <div className="max-w-7xl mx-auto px-4">
          <div className="text-center mb-16">
            <h2 className="text-3xl font-bold mb-4">데이터로 완성하는 광고 성과, NHN ACE의 기술력</h2>
            <p className="text-gray-500">정교한 타겟팅부터 자동 최적화까지, NHN ACE의 기술이 퍼포먼스를 만듭니다.</p>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
            {FEATURES.map((feature, idx) => (
              <motion.div 
                key={idx}
                whileHover={{ y: -5 }}
                className="bg-gray-50 p-8 rounded-2xl flex flex-col justify-between min-h-[200px]"
              >
                <div>
                  <h4 className="text-xl font-bold mb-2">{feature.title}</h4>
                  <p className="text-sm text-gray-500">{feature.desc}</p>
                </div>
                <div className="flex justify-end">
                  <feature.icon size={48} className={feature.color} />
                </div>
              </motion.div>
            ))}
          </div>
        </div>
      </section>

      {/* Banner */}
      <section className="relative h-64 flex items-center overflow-hidden">
        <img 
          src="https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&q=80&w=2000" 
          alt="Banner" 
          className="absolute inset-0 w-full h-full object-cover"
          referrerPolicy="no-referrer"
        />
        <div className="absolute inset-0 bg-black/60" />
        <div className="relative max-w-7xl mx-auto px-4 w-full">
          <h2 className="text-3xl md:text-4xl font-bold text-white">
            데이터로 이루어내는 성과,<br />
            NHN ACE 가 함께 합니다.
          </h2>
        </div>
      </section>

      {/* Insights */}
      <section className="py-24 bg-white">
        <div className="max-w-7xl mx-auto px-4">
          <div className="text-center mb-16">
            <h2 className="text-3xl font-bold uppercase tracking-tight">AD MARKETING INSIGHT & TRENDS</h2>
            <p className="text-gray-500 mt-2">NHN ACE의 시각으로 읽는 업계 동향, 그리고 인사이트를 확인하세요.</p>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
            {INSIGHTS.map(insight => (
              <div key={insight.id} className="group cursor-pointer">
                <div className="aspect-video rounded-2xl overflow-hidden mb-6">
                  <img 
                    src={insight.image} 
                    alt={insight.title} 
                    className="w-full h-full object-cover group-hover:scale-105 transition-transform duration-500"
                    referrerPolicy="no-referrer"
                  />
                </div>
                <div className="flex gap-2 mb-4">
                  {insight.tags.map(tag => (
                    <span key={tag} className="text-[10px] font-bold text-gray-400 uppercase">{tag}</span>
                  ))}
                </div>
                <h4 className="text-lg font-bold leading-snug group-hover:text-red-600 transition-colors">
                  {insight.title}
                </h4>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* Partners */}
      <section className="py-24 border-t border-gray-100">
        <div className="max-w-7xl mx-auto px-4">
          <div className="text-center mb-12">
            <h2 className="text-2xl font-bold">Partnering for Performance — With NHN ACE</h2>
            <p className="text-gray-400 text-sm mt-2">NHN ACE는 다양한 미디어 및 파트너사와 함께 성공을 만들어가고 있습니다.</p>
          </div>
          <div className="grid grid-cols-2 md:grid-cols-5 gap-8 items-center opacity-40">
            {PARTNERS.map((logo, idx) => (
              <img key={idx} src={logo} alt="Partner" className="h-8 mx-auto object-contain" referrerPolicy="no-referrer" />
            ))}
          </div>
        </div>
      </section>

      {/* Contact Form */}
      <section className="bg-[#5c88c4] py-24 text-white">
        <div className="max-w-7xl mx-auto px-4">
          <div className="grid grid-cols-1 md:grid-cols-3 gap-16">
            <div className="md:col-span-1">
              <span className="text-xs font-bold uppercase tracking-widest opacity-60">Contact us</span>
              <h2 className="text-4xl font-bold mt-4 mb-6">당신의 마케팅,<br />NHN ACE와 함께하세요</h2>
              <p className="text-white/70 text-sm leading-relaxed">
                광고 성과를 높이고 싶은 모든 브랜드를 위해<br />
                NHN ACE는 데이터 기반 솔루션과 전문 인사이트로 함께합니다.
              </p>
            </div>
            
            <div className="md:col-span-2">
              <form className="grid grid-cols-1 md:grid-cols-2 gap-6">
                <div className="space-y-2">
                  <label className="text-xs font-bold uppercase opacity-60">서비스 구분</label>
                  <select className="w-full bg-white/10 border border-white/20 rounded-lg px-4 py-3 text-sm focus:bg-white focus:text-black outline-none transition-all">
                    <option>선택</option>
                  </select>
                </div>
                <div className="space-y-2">
                  <label className="text-xs font-bold uppercase opacity-60">문의 구분</label>
                  <select className="w-full bg-white/10 border border-white/20 rounded-lg px-4 py-3 text-sm focus:bg-white focus:text-black outline-none transition-all">
                    <option>선택</option>
                  </select>
                </div>
                <div className="space-y-2">
                  <label className="text-xs font-bold uppercase opacity-60">이름 (회사명)</label>
                  <input type="text" placeholder="이름 (회사명)" className="w-full bg-white/10 border border-white/20 rounded-lg px-4 py-3 text-sm focus:bg-white focus:text-black outline-none transition-all placeholder:text-white/40" />
                </div>
                <div className="space-y-2">
                  <label className="text-xs font-bold uppercase opacity-60">전화번호 (-포함)</label>
                  <input type="text" placeholder="전화번호 (-포함)" className="w-full bg-white/10 border border-white/20 rounded-lg px-4 py-3 text-sm focus:bg-white focus:text-black outline-none transition-all placeholder:text-white/40" />
                </div>
                <div className="md:col-span-2 space-y-2">
                  <label className="text-xs font-bold uppercase opacity-60">이메일</label>
                  <input type="email" placeholder="이메일" className="w-full bg-white/10 border border-white/20 rounded-lg px-4 py-3 text-sm focus:bg-white focus:text-black outline-none transition-all placeholder:text-white/40" />
                </div>
                <div className="md:col-span-2 space-y-2">
                  <label className="text-xs font-bold uppercase opacity-60">제목</label>
                  <input type="text" placeholder="제목" className="w-full bg-white/10 border border-white/20 rounded-lg px-4 py-3 text-sm focus:bg-white focus:text-black outline-none transition-all placeholder:text-white/40" />
                </div>
                <div className="md:col-span-2 space-y-2">
                  <label className="text-xs font-bold uppercase opacity-60">문의내용</label>
                  <textarea rows={4} placeholder="문의내용" className="w-full bg-white/10 border border-white/20 rounded-lg px-4 py-3 text-sm focus:bg-white focus:text-black outline-none transition-all placeholder:text-white/40 resize-none" />
                </div>
                
                <div className="md:col-span-2 flex items-start gap-3 py-4">
                  <input type="checkbox" id="privacy" className="mt-1" />
                  <label htmlFor="privacy" className="text-xs text-white/60 leading-tight">
                    개인정보 수집 및 이용안내에 동의합니다.
                  </label>
                </div>

                <div className="md:col-span-2">
                  <button type="submit" className="w-full py-4 bg-black text-white font-bold rounded-lg hover:bg-white hover:text-black transition-all">
                    문의하기
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="bg-gray-50 py-16 border-t border-gray-200">
        <div className="max-w-7xl mx-auto px-4">
          <div className="flex flex-col md:flex-row justify-between items-start gap-12">
            <div>
              <h1 className="text-xl font-black tracking-tighter mb-6">
                NHN <span className="text-red-600">ACE</span>
              </h1>
              <div className="text-xs text-gray-500 space-y-1">
                <p>경기도 성남시 분당구 대왕판교로 645번길 16 플레이뮤지엄 NHN ACE</p>
                <p>사업자등록번호 : 312-81-35670 | 대표이사 : 이진수 | 이메일 : ace@nhnace.com</p>
                <p className="mt-4">Copyright © NHN ACE All rights reserved.</p>
              </div>
            </div>
            
            <div className="flex flex-col items-end gap-8">
              <div className="flex gap-6 text-xs font-bold">
                <a href="#" className="hover:text-red-600">회사소개</a>
                <a href="#" className="hover:text-red-600">이용약관</a>
                <a href="#" className="text-black">개인정보 처리방침</a>
                <a href="#" className="hover:text-red-600">채용</a>
              </div>
              <select className="bg-white border border-gray-200 rounded px-4 py-2 text-xs font-bold outline-none">
                <option>Family Site</option>
              </select>
            </div>
          </div>
        </div>
      </footer>
    </div>
  );
}
