import { motion } from 'motion/react';
import { Mail, MapPin, User } from 'lucide-react';

export default function About() {
  return (
    <div className="pt-32 pb-24">
      <div className="max-w-7xl mx-auto px-6">
        <div className="grid md:grid-cols-2 gap-16 items-center">
          <motion.div
            initial={{ opacity: 0, x: -50 }}
            animate={{ opacity: 1, x: 0 }}
            transition={{ duration: 0.8 }}
          >
            <h1 className="text-4xl md:text-6xl font-bold tracking-tight mb-8">
              Passionate about <br />
              <span className="text-blue-600 dark:text-blue-400">Digital Craftsmanship</span>.
            </h1>
            <div className="space-y-6 text-lg text-zinc-600 dark:text-zinc-400 leading-relaxed">
              <p>
                I'm a frontend developer based in Seoul, South Korea. I have a deep passion for creating intuitive, user-friendly, and visually appealing web experiences.
              </p>
              <p>
                My journey in web development started with a curiosity for how things work on the internet. Over the years, I've honed my skills in modern frameworks like React and specialized in building responsive, high-performance applications.
              </p>
              <p>
                When I'm not coding, you can find me exploring new design trends, contributing to open-source projects, or enjoying a good cup of coffee while reading about technology.
              </p>
            </div>

            <div className="mt-12 grid grid-cols-1 sm:grid-cols-2 gap-6">
              <div className="flex items-center space-x-4 p-4 bg-zinc-50 dark:bg-zinc-900 rounded-2xl border border-zinc-100 dark:border-zinc-800">
                <div className="p-3 bg-blue-50 dark:bg-blue-900/20 text-blue-600 dark:text-blue-400 rounded-xl">
                  <User size={20} />
                </div>
                <div>
                  <div className="text-xs text-zinc-400 uppercase tracking-wider font-bold">Name</div>
                  <div className="font-medium">John Doe</div>
                </div>
              </div>
              <div className="flex items-center space-x-4 p-4 bg-zinc-50 dark:bg-zinc-900 rounded-2xl border border-zinc-100 dark:border-zinc-800">
                <div className="p-3 bg-blue-50 dark:bg-blue-900/20 text-blue-600 dark:text-blue-400 rounded-xl">
                  <MapPin size={20} />
                </div>
                <div>
                  <div className="text-xs text-zinc-400 uppercase tracking-wider font-bold">Location</div>
                  <div className="font-medium">Seoul, South Korea</div>
                </div>
              </div>
              <div className="flex items-center space-x-4 p-4 bg-zinc-50 dark:bg-zinc-900 rounded-2xl border border-zinc-100 dark:border-zinc-800">
                <div className="p-3 bg-blue-50 dark:bg-blue-900/20 text-blue-600 dark:text-blue-400 rounded-xl">
                  <Mail size={20} />
                </div>
                <div>
                  <div className="text-xs text-zinc-400 uppercase tracking-wider font-bold">Email</div>
                  <div className="font-medium">john@example.com</div>
                </div>
              </div>
            </div>
          </motion.div>

          <motion.div
            initial={{ opacity: 0, scale: 0.9 }}
            animate={{ opacity: 1, scale: 1 }}
            transition={{ duration: 0.8, delay: 0.2 }}
            className="relative"
          >
            <div className="aspect-[4/5] rounded-3xl overflow-hidden shadow-2xl">
              <img
                src="https://picsum.photos/seed/about/800/1000"
                alt="About Me"
                className="w-full h-full object-cover"
                referrerPolicy="no-referrer"
              />
            </div>
            <div className="absolute -bottom-8 -right-8 w-48 h-48 bg-blue-600/10 rounded-full blur-3xl -z-10" />
          </motion.div>
        </div>
      </div>
    </div>
  );
}
