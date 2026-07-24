package com.demo.portfolio.dataInitializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.demo.portfolio.entity.Blog;
import com.demo.portfolio.entity.Profile;
import com.demo.portfolio.entity.Project;
import com.demo.portfolio.entity.Skill;
import com.demo.portfolio.repository.BlogRepository;
import com.demo.portfolio.repository.ProfileRepository;
import com.demo.portfolio.repository.ProjectRepository;
import com.demo.portfolio.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProfileRepository profileRepository;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final BlogRepository blogRepository; // 1. BlogRepository ထည့်သွင်းခြင်း

    @Override
    public void run(String... args) throws Exception {
        skillRepository.deleteAll();
        projectRepository.deleteAll();
        profileRepository.deleteAll();
        blogRepository.deleteAll(); // 2. အဟောင်းများရှိပါက ဖျက်ပြီး အသစ်ပြန်ထည့်ရန်

        Profile profile = new Profile();
        profile.setId(1L);
        profile.setName("Arkar Phone Pyae");
        profile.setTitle("Junior Software Developer");
        profile.setBio("Passionate about building scalable web applications and mastering Java Spring Boot architecture.");
        profile.setGithubUrl("https://github.com/ArkarPhonePyae");
        profile.setLinkedinUrl("https://linkedin.com/in/ArkarPhonePyae");
        profile.setEmail("arkarphonepyae58@gmail.com");
        profileRepository.save(profile);

        addSkill("Java", "Backend", 90, profile);
        addSkill("Spring Boot", "Backend", 85, profile);
        addSkill("Angular", "Frontend", 80, profile);
        addSkill("TypeScript", "Frontend", 85, profile);
        addSkill("MySQL", "Database", 85, profile);
        addSkill("Docker", "Infrastructure", 70, profile);

        Project p1 = new Project();
        p1.setTitle("SAAS-POS Backend");
        p1.setDescription("Enterprise POS System Backend.");
        p1.setTechStack("Java, Spring Boot, MySQL");
        p1.setGithubLink("https://github.com/ArkarPhonePyae/SAAS-POS-Backend");
        p1.setDemoLink("https://github.com/ArkarPhonePyae/SAAS-POS-Backend"); 
        projectRepository.save(p1);

        Project p2 = new Project();
        p2.setTitle("Fintech Expense Settler");
        p2.setDescription("Expense Management System.");
        p2.setTechStack("Java, Angular, MySQL");
        p2.setGithubLink("https://github.com/ArkarPhonePyae/fintech-expense-settler");
        p2.setDemoLink("https://github.com/ArkarPhonePyae/fintech-expense-settler");
        projectRepository.save(p2);

        Project p3 = new Project();
        p3.setTitle("POS System (Frontend)");
        p3.setDescription("Frontend for the POS System.");
        p3.setTechStack("Angular, TypeScript");
        p3.setGithubLink("https://github.com/ArkarPhonePyae/SAAS-POS-system-");
        p3.setDemoLink("https://github.com/ArkarPhonePyae/SAAS-POS-system-");
        projectRepository.save(p3);

        // 3. Blogs Data များ ထည့်သွင်းခြင်း (သင့်ရဲ့ Entity ဖွဲ့စည်းပုံအတိုင်း)
        Blog blog1 = new Blog();
        blog1.setTitle("Getting Started with Spring Boot on Production");
        blog1.setCategory("Backend");
        blog1.setPublicationDate(LocalDate.now());
        blog1.setDescription("A complete guide to deploying Spring Boot applications to Render with Railway MySQL.");
        blog1.setContent("Full detailed content about Spring Boot production deployment steps...");
        blog1.setReadTimeMinutes(5);
        blogRepository.save(blog1);

        Blog blog2 = new Blog();
        blog2.setTitle("Angular Best Practices for Modern Web Apps");
        blog2.setCategory("Frontend");
        blog2.setPublicationDate(LocalDate.now());
        blog2.setDescription("Learn how to structure your Angular project for scalability and clean code architecture.");
        blog2.setContent("Full detailed content about Angular best practices and components...");
        blog2.setReadTimeMinutes(4);
        blogRepository.save(blog2);
    }

    private void addSkill(String name, String category, int percentage, Profile profile) {
        Skill skill = new Skill();
        skill.setName(name);
        skill.setCategory(category);
        skill.setPercentage(percentage);
        skill.setProfile(profile);
        skillRepository.save(skill);
    }
}