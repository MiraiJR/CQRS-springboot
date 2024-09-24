import { BASE_URL_API } from "../shared/constant";

export interface CategoryTree {
  id: number;
  childrens: CategoryTree[];
  name: string;
  slug: string;
}

export const getCategoryTree = async (): Promise<CategoryTree[]> => {
  const response = await fetch(`${BASE_URL_API}/categories`);
  const data = await response.json();
  return data;
};
