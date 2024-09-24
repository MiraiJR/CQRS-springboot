import { createFileRoute } from "@tanstack/react-router";
import { CategoryTree, getCategoryTree } from "../../api/products";

export interface CategoryTreeProps {
  category: CategoryTree;
}
export const CategoryTreeComponent = ({ category }: CategoryTreeProps) => {
  return (
    <div>
      <li>{category.name}</li>
      {category.childrens && (
        <ul className="list-disc m-3">
          {category.childrens.map((categoryChild) => (
            <CategoryTreeComponent
              category={categoryChild}
              key={categoryChild.id}
            />
          ))}
        </ul>
      )}
    </div>
  );
};

export const Index = () => {
  const categories = Route.useLoaderData();

  return (
    <div className="mx-3 my-6 flex gap-32">
      <div>
        <h2 className="text-xl font-bold">Categories</h2>
        <ul className="list-disc m-3">
          {categories.map((category) => (
            <CategoryTreeComponent category={category} key={category.id} />
          ))}
        </ul>
      </div>
    </div>
  );
};

export const Route = createFileRoute("/product/")({
  component: Index,
  loader: () => getCategoryTree(),
});
