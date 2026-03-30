import { EXPERIENCE } from '../constants';
import Timeline from '../components/Timeline/Timeline';
import { motion } from 'motion/react';

export default function Experience() {
  return (
    <div className="pt-32 pb-24">
      <div className="max-w-7xl mx-auto px-6">
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          className="text-center mb-16"
        >
          <h1 className="text-4xl md:text-6xl font-bold tracking-tight mb-6">Experience</h1>
          <p className="text-zinc-500 dark:text-zinc-400 max-w-lg mx-auto text-lg">
            My professional journey and career milestones.
          </p>
        </motion.div>

        <Timeline items={EXPERIENCE} />
      </div>
    </div>
  );
}
