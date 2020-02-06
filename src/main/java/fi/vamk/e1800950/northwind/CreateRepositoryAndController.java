package fi.vamk.e1800950.northwind;

import java.io.File;
import java.io.FileWriter;

public class CreateRepositoryAndController {
	private static File folder = new File("/Users/minhhoang/Downloads/northwind/src/main/java/fi/vamk/e1800950/northwind");

	public static void main(String[] args) {
		System.out.println("Reading files under the folder " + folder.getAbsolutePath());
		listFilesForFolder(folder);
	}

	public static void listFilesForFolder(final File folder) {
		for (final File newEntry:folder.listFiles()) {
			if (newEntry.isDirectory()) listFilesForFolder(newEntry);
			else {
				if (newEntry.isFile()) {
					String fileName = newEntry.getName();
					String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length()).toLowerCase();
					
					if (fileExtension.equals("java")) {

						// extract just the name part of the file
						String temp = fileName.substring(0, fileName.lastIndexOf('.'));

						// create repository & controller file if does not exist
						if (!temp.equals("CreateRepositoryAndController") && !temp.equals("NorthwindApplication") 
							&& !temp.contains("Repository") && !temp.contains("Controller")) {
								createRepositoryFile(temp);
								createControllerFile(temp);
						}
					}
				}
			}
		}
	}

	public static void createRepositoryFile(String fileName) {
		try {
			File repositoryFile = new File(folder + "/" + fileName + "Repository.java");
			FileWriter content = new FileWriter(repositoryFile);

			content.write("package fi.vamk.e1800950.northwind;\n\n");
			content.write("import org.springframework.data.repository.CrudRepository;\n\n");
			content.write("public interface " + fileName + "Repository extends CrudRepository<"
							+ fileName + ", Integer> {\n\n}");
			content.close();
		} catch (Exception e) {
			//TODO: handle exception
			System.out.println("Cannot create file");
		}
	}

	public static void createControllerFile(String fileName) {
		try {
			File controllerFile = new File(folder + "/" + fileName + "Controller.java");
			FileWriter content = new FileWriter(controllerFile);

			content.write("package fi.vamk.e1800950.northwind;\n\n");
			content.write("import java.util.Optional;\n\n");
			content.write("import org.springframework.beans.factory.annotation.Autowired;\n");
			content.write("import org.springframework.web.bind.annotation.PathVariable;\n");
			content.write("import org.springframework.web.bind.annotation.RequestBody;\n");
			content.write("import org.springframework.web.bind.annotation.RequestMapping;\n");
			content.write("import org.springframework.web.bind.annotation.RequestMethod;\n");
			content.write("import org.springframework.web.bind.annotation.ResponseBody;\n");
			content.write("import org.springframework.web.bind.annotation.RestController;\n\n");

			content.write("@RestController\n");
			content.write("public class " + fileName + "Controller {\n");
			content.write("\t@Autowired\n");
			content.write("\tprivate " + fileName + "Repository repository;\n\n");

			content.write("\t// returning all " + fileName + "s\n");
			content.write("\t@RequestMapping(\"/" + fileName + "s\")\n");
			content.write("\tpublic Iterable<" + fileName + "> " + fileName.toLowerCase() + "s() {\n");
			content.write("\t\treturn repository.findAll();\n\t}\n\n");

			content.write("\t// returning one " + fileName + " only\n");
			content.write("\t@RequestMapping(\"/" + fileName + "/{id}\")\n");
			content.write("\tpublic Optional<" + fileName + "> get(@PathVariable(\"id\") int id) {\n");
			content.write("\t\treturn repository.findById(id);\n\t}\n\n");

			content.write("\t // create a new " + fileName + "\n");
			content.write("\t@RequestMapping(value = \"/" + fileName + "\", method = RequestMethod.POST)\n");
			content.write("\tpublic @ResponseBody " + fileName + " create(@RequestBody " + fileName + " item) {\n");
			content.write("\t\treturn repository.save(item);\n\t}\n\n");

			content.write("\t // update an existing " + fileName + "\n");
			content.write("\t@RequestMapping(value = \"/" + fileName + "\", method = RequestMethod.PUT)\n");
			content.write("\tpublic @ResponseBody " + fileName + " update(@RequestBody " + fileName + " item) {\n");
			content.write("\t\treturn repository.save(item);\n\t}\n\n");

			content.write("\t // delete a " + fileName + "\n");
			content.write("\t@RequestMapping(value = \"/" + fileName + "\", method = RequestMethod.DELETE)\n");
			content.write("\tpublic void delete(@RequestBody " + fileName + " item) {\n");
			content.write("\t\trepository.delete(item);\n\t}\n\n");

			content.write("}");

			content.close();
		} catch (Exception e) {
			//TODO: handle exception
			System.out.println("Cannot create file");
		}
	}
}
