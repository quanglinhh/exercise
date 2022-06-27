using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7
{
    internal class Project
    {
        public int ProjectId { get; set; }
        public  string ProjectName { get; set; }

        public Project(int projectId, string projectName)
        {
            ProjectId = projectId;
            ProjectName = projectName;
        }
        public override string ToString()
        {
            return $"ProjetId: {ProjectId}, ProjectName {ProjectName}";
        }
    }
}
