import { Project, SkillCategory, ExperienceItem } from './types';

export const PROJECTS: Project[] = [
  {
    id: 1,
    title: "E-Commerce Platform",
    description: "A full-featured online store with cart functionality and payment integration.",
    thumbnail: "https://picsum.photos/seed/ecommerce/600/400",
    tags: ["React", "Tailwind", "Node.js"],
    githubUrl: "https://github.com",
    demoUrl: "https://example.com"
  },
  {
    id: 2,
    title: "Task Management App",
    description: "A productivity tool for managing daily tasks and team collaboration.",
    thumbnail: "https://picsum.photos/seed/task/600/400",
    tags: ["React", "Firebase", "Motion"],
    githubUrl: "https://github.com",
    demoUrl: "https://example.com"
  },
  {
    id: 3,
    title: "Weather Dashboard",
    description: "Real-time weather tracking with interactive maps and forecasts.",
    thumbnail: "https://picsum.photos/seed/weather/600/400",
    tags: ["JavaScript", "API", "CSS"],
    githubUrl: "https://github.com",
    demoUrl: "https://example.com"
  }
];

export const SKILLS: SkillCategory[] = [
  {
    category: "Frontend",
    skills: [
      { name: "HTML", level: 95 },
      { name: "CSS", level: 90 },
      { name: "JavaScript", level: 85 },
      { name: "React", level: 80 },
      { name: "jQuery", level: 70 }
    ]
  },
  {
    category: "Backend",
    skills: [
      { name: "Java", level: 75 },
      { name: "MySQL", level: 70 }
    ]
  },
  {
    category: "Tools",
    skills: [
      { name: "Git", level: 85 },
      { name: "VS Code", level: 90 },
      { name: "Eclipse", level: 70 }
    ]
  }
];

export const EXPERIENCE: ExperienceItem[] = [
  {
    id: 1,
    period: "2024 - Present",
    company: "Tech Innovators Inc.",
    role: "Frontend Developer",
    description: [
      "Developing responsive web applications using React and Tailwind CSS.",
      "Collaborating with UI/UX designers to implement pixel-perfect interfaces.",
      "Optimizing application performance and accessibility."
    ]
  },
  {
    id: 2,
    period: "2022 - 2024",
    company: "Creative Solutions",
    role: "Junior Web Developer",
    description: [
      "Maintained and updated client websites using HTML, CSS, and JavaScript.",
      "Assisted in the migration of legacy codebases to modern frameworks.",
      "Participated in daily stand-ups and code reviews."
    ]
  }
];
