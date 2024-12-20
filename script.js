class Terminal {
  constructor() {
    this.output = document.querySelector("#output .output-wrapper");
    this.input = document.getElementById("terminal-input");
    this.typewriterSpeed = 4;
    this.lineDelay = 10;
    this.commandHistory = [];
    this.historyIndex = -1;
    this.instantType = false;

    // Available commands and their descriptions
    this.commands = {
      help: "Display available commands",
      about: "Display welcome message",
      skills: "List my technical skills",
      work: "Show my work history",
      projects: "View my projects",
      clear: "Clear the terminal",
    };

    // Add new property to track rendering state
    this.isRendering = false;

    // Bind event listeners
    this.setupEventListeners();
  }

  setupEventListeners() {
    this.input.addEventListener("keydown", (e) => this.handleKeyPress(e));

    // Add click handler to skip animation
    document.addEventListener("click", () => {
      if (this.isRendering) {
        this.instantType = true;
      }
    });
  }

  async handleKeyPress(e) {
    // Prevent command execution while rendering
    if (e.key === "Enter" && this.isRendering) {
      e.preventDefault();
      return;
    }

    if (e.key === "Enter") {
      const command = this.input.value.trim().toLowerCase();
      this.commandHistory.push(command);
      this.historyIndex = this.commandHistory.length;

      // Disable input during command execution
      this.isRendering = true;
      this.input.disabled = true;

      // Create command line with input
      await this.typeText(`> ${command}`, 0);

      // Process command
      await this.processCommand(command);

      // Re-enable input after command execution
      this.isRendering = false;
      this.input.disabled = false;
      this.input.focus();

      // Clear input
      this.input.value = "";
    } else if (e.key === "ArrowUp") {
      if (!this.isRendering) {
        e.preventDefault();
        this.navigateHistory("up");
      }
    } else if (e.key === "ArrowDown") {
      if (!this.isRendering) {
        e.preventDefault();
        this.navigateHistory("down");
      }
    }
  }

  navigateHistory(direction) {
    if (direction === "up" && this.historyIndex > 0) {
      this.historyIndex--;
      this.input.value = this.commandHistory[this.historyIndex];
    } else if (
      direction === "down" &&
      this.historyIndex < this.commandHistory.length - 1
    ) {
      this.historyIndex++;
      this.input.value = this.commandHistory[this.historyIndex];
    } else if (direction === "down") {
      this.historyIndex = this.commandHistory.length;
      this.input.value = "";
    }
  }

  async processCommand(command) {
    switch (command) {
      case "help":
        await this.showHelp();
        break;
      case "about":
        await this.showAbout();
        break;
      case "skills":
        await this.showSkills();
        break;
      case "work":
        await this.showWork();
        break;
      case "projects":
        await this.showProjects();
        break;
      case "clear":
        this.clearTerminal();
        break;
      case "":
        break;
      default:
        await this.typeText(
          `Command not found: ${command}. Type 'help' for available commands.`
        );
    }
    this.smoothScrollToBottom();
  }

  async showHelp() {
    await this.typeText("**Available commands:**");
    for (const [command, description] of Object.entries(this.commands)) {
      await this.typeText(`  ${command.padEnd(10)} - ${description}`);
    }
  }

  async showAbout() {
    const welcomeLines = [
      "Portfolio v1.0.0 loaded successfully.",
      "(forever) A student with a strong passion for computers and a desire to change the world.",
      "Account: Sid Premkumar",
      "Location: New York, NY",
      "",
      {
        type: "image",
        src: "images/linkedin-dp.jpeg",
        alt: "Sid Premkumar",
      },
      "Type 'help' to see available commands.",
      "**-----------------------------------**",
      "**skills** - View Technical Skills",
      "**work** - View Work History",
      "**projects** - View Projects",
      "**clear** - Clear the terminal",
      "**-----------------------------------**",
    ];

    await this.typeLines(welcomeLines);
  }

  async showSkills() {
    const skills = [
      "**Infrastructure**",
      "------------",
      {
        type: "image",
        src: "images/kuberentes-logo.png",
        alt: "Kubernetes Logo",
      },
      "• Kubernetes - Container orchestration and deployment",
      "• Terraform - Infrastructure as Code",
      "• AWS Services:",
      "  - Virtual Private Cloud (VPC)",
      "  - CloudFormation",
      "  - Elastic Compute Cloud (EC2)",
      "  - Elastic Kubernetes Service (EKS)",
      "  - Elastic Container Service (ECS)",
      "  - And many more AWS services",
      "",
      "**Languages**",
      "---------",
      {
        type: "image",
        src: "images/typescript-logo.png",
        alt: "TypeScript Logo",
      },
      "• Golang - Backend services & CLI tools",
      "• TypeScript - Full-stack development",
      "• Python - Automation & Data Processing",
      "• C# - .NET Applications",
      "",
      "**Frameworks & Technologies**",
      "----------------------",
      "• Kafka - Event streaming & message queues",
      "• Prisma - Next-generation ORM",
      "• NextJS - React framework for production",
      "• React - Frontend development",
      "• React Native - Mobile development",
      "",
    ];

    await this.typeLines(skills);
  }

  async showWork() {
    const workHistory = [
      {
        title: "**CO-FOUNDER/CTO**",
        company: "**LYTIX**",
        location: "New York",
        period: "January 2024 - Present",
        image: {
          type: "image",
          src: "images/lytix_logo.jpeg",
          alt: "Lytix Logo",
        },
        details: [
          "• Part of the Y Combinator W24 batch to build a product from scratch",
          "• Designed and built out a LLM observability product that scaled up to handle 400,000+ messages per day at peak",
          "• Built out a micro service framework using Kubernetes (EKS) and Kafka (Strimzi) to automatically adapt to different levels of traffic",
          "• Led exploratory calls with prospects, along with the setup and support of customers",
        ],
      },
      {
        title: "**SOFTWARE ENGINEER 4**",
        company: "**TITAN**",
        location: "New York",
        period: "July 2022 - January 2024",
        image: {
          type: "image",
          src: "images/titan_invest_logo.jpeg",
          alt: "Titan Logo",
        },
        details: [
          "• Launched a new investment strategy which is used by over 3000 clients and moved over $2 million dollars in funds",
          "• Led a migration from EC2 to ECS while supporting 55,000 active clients",
          "• Implemented DDOS protection that has significantly reduced the number of incidents",
          "• Update internal network to support best AWS practices (subnet isolation, robust security groups, IAM role permission scoping etc.)",
        ],
      },
      {
        title: "**SENIOR SOFTWARE ENGINEER**",
        company: "**BASTIONZERO**",
        location: "New York",
        period: "January 2021 - June 2022",
        image: {
          type: "image",
          src: "images/bastionzero_logo.jpeg",
          alt: "BastionZero Logo",
        },
        details: [
          "• Fully rearchitect infrastructure to enable the product to dynamically scale",
          "• Led a team of 4 engineers to successfully migrate from EC2/CloudFormation to EKS/Terraform",
          "• Managed several engineers, and coordinated their projects and successful delivery",
          "• Designed and built a Kubernetes product that tunneled requests through a Bastion",
          "• Led the technical aspects of the onboarding and integration process of new customers",
          "• Represented the technical team in sales calls for prospective customers, as well as in support requests for pre-existing customers",
        ],
      },
    ];

    // Reverse the array to show oldest experience first
    for (const job of [...workHistory].reverse()) {
      await this.typeLines([
        "",
        job.image,
        `${job.title} @ ${job.company}`,
        `📍 ${job.location}`,
        `⏰ ${job.period}`,
        "",
        ...job.details,
        "",
        "-----------------------------------",
      ]);
    }
  }

  async showProjects() {
    const projects = [
      {
        title: "**Optimodel**",
        org: "Lytix-Labs",
        description: "Guards and protection agnostic to your model or provider",
        tech: "Python",
        stats: "36 stars, 1 fork",
        github: "https://github.com/Lytix-Labs/optimodel",
      },
      {
        title: "**HNews**",
        description:
          "Open source hacker news iOS and Android client written in ReactNative",
        tech: "TypeScript, React Native",
        stats: "11 stars",
        github: "https://github.com/sidpremkumar/hnews",
      },
      {
        title: "**pd2slack**",
        description: "Sync PagerDuty OnCall with Slack UserGroups",
        tech: "Python",
        stats: "3 stars",
        github: "https://github.com/sidpremkumar/pd2slack",
      },
      {
        title: "**Sync2Jira**",
        org: "release-engineering",
        description:
          "Service to sync upstream Tickets/PR's with downstream JIRA tickets!",
        tech: "Python",
        stats: "12 stars, 24 forks",
        github: "https://github.com/release-engineering/Sync2Jira",
      },
      {
        title: "**Fancy**",
        description: "How smart is your music?",
        tech: "Python",
        github: "https://github.com/sidpremkumar/fancy",
      },
      {
        title: "**Woof-Are-You**",
        description: "Have you ever wondered what type of dog you are?",
        tech: "Python",
        stats: "2 stars",
        github: "https://github.com/sidpremkumar/woof-are-you",
        // image: {
        //   type: "image",
        //   src: "images/woofareyou.jpeg",
        //   alt: "Woof Are You",
        // },
      },
    ];

    await this.typeText("**My Open Source Projects**");
    await this.typeText("----------------------");
    await this.typeText("");

    for (const project of projects) {
      const lines = [
        `${project.title}${project.org ? ` (${project.org})` : ""}`,
        project.description,
      ];

      if (project.image) {
        lines.push(project.image);
      }

      lines.push(
        `🛠️  ${project.tech}`,
        project.stats ? `⭐ ${project.stats}` : "",
        `🔗 GitHub: ${project.github}`,
        "",
        "-----------------------------------",
        ""
      );

      await this.typeLines(lines);
    }
  }

  clearTerminal() {
    this.output.innerHTML = "";
  }

  // Types out text with a typewriter effect
  async typeText(text, speed = this.typewriterSpeed) {
    const line = document.createElement("div");
    line.classList.add("terminal-line");
    this.output.appendChild(line);

    // Handle both bold text and URLs
    // Match both **bold** and URLs starting with http:// or https://
    const segments = text.split(/(\*\*.*?\*\*|https?:\/\/[^\s]+)/g);

    if (this.instantType || speed === 0) {
      segments.forEach((segment) => {
        if (segment.startsWith("**") && segment.endsWith("**")) {
          const bold = document.createElement("span");
          bold.classList.add("font-bold");
          bold.textContent = segment.slice(2, -2);
          line.appendChild(bold);
        } else if (segment.match(/^https?:\/\//)) {
          const link = document.createElement("a");
          link.href = segment;
          link.target = "_blank";
          link.textContent = segment;
          link.classList.add("text-blue-400", "hover:underline");
          line.appendChild(link);
        } else {
          line.appendChild(document.createTextNode(segment));
        }
      });
      this.smoothScrollToBottom();
      return line;
    }

    // Type each segment with formatting
    for (const segment of segments) {
      if (segment.startsWith("**") && segment.endsWith("**")) {
        const bold = document.createElement("span");
        bold.classList.add("font-bold");
        const boldText = segment.slice(2, -2);

        const chunkSize = 3;
        for (let i = 0; i < boldText.length; i += chunkSize) {
          const chunk = boldText.slice(i, i + chunkSize);
          bold.textContent += chunk;
          this.smoothScrollToBottom();
          await this.sleep(speed);
        }
        line.appendChild(bold);
      } else if (segment.match(/^https?:\/\//)) {
        const link = document.createElement("a");
        link.href = segment;
        link.target = "_blank";
        link.classList.add("text-blue-400", "hover:underline");

        const chunkSize = 3;
        for (let i = 0; i < segment.length; i += chunkSize) {
          const chunk = segment.slice(i, i + chunkSize);
          link.textContent += chunk;
          this.smoothScrollToBottom();
          await this.sleep(speed);
        }
        line.appendChild(link);
      } else {
        const chunkSize = 3;
        for (let i = 0; i < segment.length; i += chunkSize) {
          const chunk = segment.slice(i, i + chunkSize);
          line.appendChild(document.createTextNode(chunk));
          this.smoothScrollToBottom();
          await this.sleep(speed);
        }
      }
    }

    this.smoothScrollToBottom();
    return line;
  }

  // Helper function for delays
  sleep(ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
  }

  // Types multiple lines with delays between them
  async typeLines(lines) {
    for (let line of lines) {
      await this.typeContent(line);
      if (!this.instantType) {
        await this.sleep(this.lineDelay);
      }
    }
  }

  // Initialize the welcome message
  async initialize() {
    this.isRendering = true;
    this.input.disabled = true;
    this.instantType = false;

    const welcomeLines = [
      "Portfolio v1.0.0 loaded successfully.",
      "(forever) A student with a strong passion for computers and a desire to change the world.",
      "Account: Sid Premkumar",
      "Location: New York, NY",
      "",
      {
        type: "image",
        src: "images/linkedin-dp.jpeg",
        alt: "Sid Premkumar",
      },
      "Type 'help' to see available commands.",
      "**-----------------------------------**",
      "**work** - View Work History",
      "**projects** - View Projects",
      "**skills** - View Technical Skills",
      "**about** - View About Me",
      "**clear** - Clear the terminal",
      "**-----------------------------------**",
    ];

    await this.typeLines(welcomeLines);

    this.isRendering = false;
    this.input.disabled = false;
    this.input.focus();
  }

  // First, let's create a new method to handle different types of content
  async typeContent(content) {
    if (typeof content === "string") {
      return await this.typeText(content);
    } else if (content.type === "image") {
      const container = document.createElement("div");
      container.classList.add("terminal-line", "my-4");

      const img = document.createElement("img");
      img.src = content.src;
      img.alt = content.alt || "";
      img.classList.add("max-h-64", "rounded-lg");

      // Add load event listener to scroll after image loads
      img.onload = () => this.smoothScrollToBottom();

      container.appendChild(img);
      this.output.appendChild(container);
      this.smoothScrollToBottom();
      await this.sleep(this.lineDelay);
      return container;
    }
  }

  // Update smoothScrollToBottom to force scroll to bottom
  smoothScrollToBottom() {
    requestAnimationFrame(() => {
      const output = document.getElementById("output");
      output.scrollTop = output.scrollHeight;
    });
  }
}

// Initialize when the page loads
document.addEventListener("DOMContentLoaded", () => {
  window.terminal = new Terminal();
  window.terminal.initialize();

  // Ensure input is always focused
  const input = document.getElementById("terminal-input");
  input.focus();

  // Refocus input when clicking anywhere in the terminal
  document.getElementById("terminal").addEventListener("click", () => {
    input.focus();
  });
});
