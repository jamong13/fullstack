import { Link } from 'react-router-dom';
import { motion } from 'motion/react';
import { ArrowRight } from 'lucide-react';

export default function Hero() {
  return (
    <section className="relative min-h-screen flex items-center pt-20 overflow-hidden">
      {/* Background Accents */}
      <div className="absolute top-1/4 -right-20 w-96 h-96 bg-blue-100/50 dark:bg-blue-900/10 rounded-full blur-3xl -z-10" />
      <div className="absolute bottom-1/4 -left-20 w-96 h-96 bg-zinc-100/50 dark:bg-zinc-800/20 rounded-full blur-3xl -z-10" />

      <div className="max-w-7xl mx-auto px-6 grid md:grid-cols-2 gap-12 items-center">
        <motion.div
          initial={{ opacity: 0, x: -50 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 0.8, ease: "easeOut" }}
        >
          <span className="inline-block px-3 py-1 text-xs font-semibold tracking-wider text-blue-600 dark:text-blue-400 bg-blue-50 dark:bg-blue-900/20 rounded-full mb-6">
            AVAILABLE FOR WORK
          </span>
          <h1 className="text-5xl md:text-7xl font-bold tracking-tighter leading-tight mb-6">
            Hi, I'm <span className="text-blue-600 dark:text-blue-400">John Doe</span>.
            <br />
            Frontend Developer.
          </h1>
          <p className="text-lg text-zinc-600 dark:text-zinc-400 max-w-lg mb-10 leading-relaxed">
            I build modern, high-performance web applications with a focus on clean code and exceptional user experiences.
          </p>

          <div className="flex flex-wrap gap-4">
            <Link
              to="/portfolio"
              className="px-8 py-4 bg-blue-600 hover:bg-blue-700 text-white font-medium rounded-xl transition-all shadow-lg shadow-blue-600/20 flex items-center group"
            >
              View Portfolio
              <ArrowRight size={18} className="ml-2 group-hover:translate-x-1 transition-transform" />
            </Link>
            <Link
              to="/contact"
              className="px-8 py-4 bg-white dark:bg-zinc-800 border border-zinc-200 dark:border-zinc-700 hover:border-blue-600 dark:hover:border-blue-400 font-medium rounded-xl transition-all"
            >
              Contact Me
            </Link>
          </div>
        </motion.div>

        <motion.div
          initial={{ opacity: 0, scale: 0.8 }}
          animate={{ opacity: 1, scale: 1 }}
          transition={{ duration: 0.8, delay: 0.2 }}
          className="relative"
        >
          <div className="relative z-10 w-full aspect-square rounded-3xl overflow-hidden shadow-2xl">
            <img
              src="https://picsum.photos/seed/profile/800/800"
              alt="Profile"
              className="w-full h-full object-cover"
              referrerPolicy="no-referrer"
            />
          </div>
          {/* Decorative Elements */}
          <div className="absolute -top-6 -right-6 w-24 h-24 bg-blue-600 rounded-2xl -z-10 animate-pulse" />
          <div className="absolute -bottom-6 -left-6 w-32 h-32 border-4 border-zinc-200 dark:border-zinc-800 rounded-2xl -z-10" />
        </motion.div>
      </div>
    </section>
  );
}
