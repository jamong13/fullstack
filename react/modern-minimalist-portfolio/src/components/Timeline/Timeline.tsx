import { motion } from 'motion/react';
import { ExperienceItem } from '../../types';

interface TimelineProps {
  items: ExperienceItem[];
}

export default function Timeline({ items }: TimelineProps) {
  return (
    <div className="relative space-y-12 before:absolute before:inset-0 before:ml-5 before:-translate-x-px md:before:mx-auto md:before:translate-x-0 before:h-full before:w-0.5 before:bg-gradient-to-b before:from-transparent before:via-blue-200 dark:before:via-blue-900 before:to-transparent">
      {items.map((item, index) => (
        <motion.div
          key={item.id}
          initial={{ opacity: 0, x: index % 2 === 0 ? -50 : 50 }}
          whileInView={{ opacity: 1, x: 0 }}
          viewport={{ once: true }}
          transition={{ duration: 0.6, delay: index * 0.1 }}
          className="relative flex items-center justify-between md:justify-normal md:odd:flex-row-reverse group"
        >
          {/* Icon */}
          <div className="flex items-center justify-center w-10 h-10 rounded-full border border-white dark:border-zinc-800 bg-blue-50 dark:bg-blue-900/30 text-blue-600 dark:text-blue-400 shadow shrink-0 md:order-1 md:group-odd:-translate-x-1/2 md:group-even:translate-x-1/2">
            <div className="w-3 h-3 bg-blue-600 dark:bg-blue-400 rounded-full" />
          </div>

          {/* Content */}
          <div className="w-[calc(100%-4rem)] md:w-[calc(50%-2.5rem)] p-6 bg-white dark:bg-zinc-900 border border-zinc-100 dark:border-zinc-800 rounded-3xl shadow-sm group-hover:shadow-md transition-shadow">
            <div className="flex flex-col md:flex-row md:items-center justify-between mb-4">
              <div className="text-sm font-bold text-blue-600 dark:text-blue-400 uppercase tracking-wider">
                {item.period}
              </div>
              <div className="text-lg font-bold">{item.company}</div>
            </div>
            <div className="text-md font-semibold mb-4 text-zinc-700 dark:text-zinc-300">
              {item.role}
            </div>
            <ul className="space-y-2">
              {item.description.map((desc, i) => (
                <li key={i} className="text-sm text-zinc-500 dark:text-zinc-400 flex items-start">
                  <span className="mr-2 mt-1.5 w-1.5 h-1.5 rounded-full bg-blue-400 shrink-0" />
                  {desc}
                </li>
              ))}
            </ul>
          </div>
        </motion.div>
      ))}
    </div>
  );
}
