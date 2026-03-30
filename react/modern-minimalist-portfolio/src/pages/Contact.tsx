import ContactForm from '../components/ContactForm/ContactForm';
import { motion } from 'motion/react';
import { Mail, Phone, Github, Linkedin, Twitter } from 'lucide-react';

export default function Contact() {
  const socialLinks = [
    { icon: <Github size={20} />, href: "https://github.com", label: "GitHub" },
    { icon: <Linkedin size={20} />, href: "https://linkedin.com", label: "LinkedIn" },
    { icon: <Twitter size={20} />, href: "https://twitter.com", label: "Twitter" },
  ];

  return (
    <div className="pt-32 pb-24">
      <div className="max-w-7xl mx-auto px-6">
        <div className="grid md:grid-cols-2 gap-16">
          <motion.div
            initial={{ opacity: 0, x: -50 }}
            animate={{ opacity: 1, x: 0 }}
            transition={{ duration: 0.8 }}
          >
            <h1 className="text-4xl md:text-6xl font-bold tracking-tight mb-8">
              Let's <span className="text-blue-600 dark:text-blue-400">Connect</span>.
            </h1>
            <p className="text-lg text-zinc-600 dark:text-zinc-400 mb-12 leading-relaxed">
              I'm always open to discussing new projects, creative ideas, or opportunities to be part of your visions.
            </p>

            <div className="space-y-8 mb-12">
              <div className="flex items-center space-x-6">
                <div className="p-4 bg-blue-50 dark:bg-blue-900/20 text-blue-600 dark:text-blue-400 rounded-2xl">
                  <Mail size={24} />
                </div>
                <div>
                  <div className="text-xs text-zinc-400 uppercase tracking-wider font-bold">Email</div>
                  <div className="text-lg font-medium">john@example.com</div>
                </div>
              </div>
              <div className="flex items-center space-x-6">
                <div className="p-4 bg-blue-50 dark:bg-blue-900/20 text-blue-600 dark:text-blue-400 rounded-2xl">
                  <Phone size={24} />
                </div>
                <div>
                  <div className="text-xs text-zinc-400 uppercase tracking-wider font-bold">Phone</div>
                  <div className="text-lg font-medium">+82 10-1234-5678</div>
                </div>
              </div>
            </div>

            <div>
              <div className="text-sm font-bold text-zinc-400 uppercase tracking-wider mb-6">Follow Me</div>
              <div className="flex space-x-4">
                {socialLinks.map((link, i) => (
                  <a
                    key={i}
                    href={link.href}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="p-4 bg-zinc-50 dark:bg-zinc-900 border border-zinc-100 dark:border-zinc-800 rounded-2xl text-zinc-500 hover:text-blue-600 hover:border-blue-600 transition-all"
                    aria-label={link.label}
                  >
                    {link.icon}
                  </a>
                ))}
              </div>
            </div>
          </motion.div>

          <ContactForm />
        </div>
      </div>
    </div>
  );
}
