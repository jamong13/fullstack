import { SKILLS } from '../constants';
import SkillCard from '../components/SkillCard/SkillCard';
import { motion } from 'motion/react';

export default function Skills() {
  return (
    <div className="pt-32 pb-24">
      <div className="max-w-7xl mx-auto px-6">
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          className="text-center mb-16"
        >
          <h1 className="text-4xl md:text-6xl font-bold tracking-tight mb-6">Technical Skills</h1>
          <p className="text-zinc-500 dark:text-zinc-400 max-w-lg mx-auto text-lg">
            My technical stack and tools I use to bring ideas to life.
          </p>
        </motion.div>

        <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-8">
          {SKILLS.map((category) => (
            <SkillCard key={category.category} category={category} />
          ))}
        </div>
      </div>
    </div>
  );
}
