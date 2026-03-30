import Hero from '../components/Hero/Hero';
import { PROJECTS, SKILLS, EXPERIENCE } from '../constants';
import ProjectCard from '../components/ProjectCard/ProjectCard';
import SkillCard from '../components/SkillCard/SkillCard';
import Timeline from '../components/Timeline/Timeline';
import { Link } from 'react-router-dom';
import { ArrowRight } from 'lucide-react';

export default function Home() {
  return (
    <div>
      <Hero />

      {/* Featured Projects Section */}
      <section className="py-24 bg-zinc-50 dark:bg-zinc-900/30">
        <div className="max-w-7xl mx-auto px-6">
          <div className="flex justify-between items-end mb-12">
            <div>
              <h2 className="text-3xl md:text-4xl font-bold tracking-tight mb-4">Featured Projects</h2>
              <p className="text-zinc-500 dark:text-zinc-400 max-w-md">
                A selection of my recent work and personal projects.
              </p>
            </div>
            <Link
              to="/portfolio"
              className="hidden md:flex items-center text-blue-600 dark:text-blue-400 font-semibold hover:underline"
            >
              View all projects <ArrowRight size={18} className="ml-1" />
            </Link>
          </div>

          <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-8">
            {PROJECTS.slice(0, 3).map((project) => (
              <ProjectCard key={project.id} project={project} />
            ))}
          </div>
        </div>
      </section>

      {/* Skills Preview */}
      <section className="py-24">
        <div className="max-w-7xl mx-auto px-6">
          <div className="text-center mb-16">
            <h2 className="text-3xl md:text-4xl font-bold tracking-tight mb-4">Technical Expertise</h2>
            <p className="text-zinc-500 dark:text-zinc-400 max-w-lg mx-auto">
              I specialize in building modern web applications using the latest technologies.
            </p>
          </div>

          <div className="grid md:grid-cols-3 gap-8">
            {SKILLS.map((category) => (
              <SkillCard key={category.category} category={category} />
            ))}
          </div>
        </div>
      </section>

      {/* Experience Preview */}
      <section className="py-24 bg-zinc-50 dark:bg-zinc-900/30">
        <div className="max-w-7xl mx-auto px-6">
          <div className="text-center mb-16">
            <h2 className="text-3xl md:text-4xl font-bold tracking-tight mb-4">Work Experience</h2>
            <p className="text-zinc-500 dark:text-zinc-400 max-w-lg mx-auto">
              My professional journey and career milestones.
            </p>
          </div>

          <Timeline items={EXPERIENCE} />
        </div>
      </section>
    </div>
  );
}
