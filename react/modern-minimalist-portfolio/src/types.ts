export interface Project {
  id: number;
  title: string;
  description: string;
  thumbnail: string;
  tags: string[];
  githubUrl?: string;
  demoUrl?: string;
}

export interface Skill {
  name: string;
  level: number; // 0-100
  icon?: string;
}

export interface SkillCategory {
  category: string;
  skills: Skill[];
}

export interface ExperienceItem {
  id: number;
  period: string;
  company: string;
  role: string;
  description: string[];
}
