import { createFileRoute } from "@tanstack/react-router";

export const Index = () => {
  return <>This is the about page</>;
};

export const Route = createFileRoute("/about/")({
  component: Index,
});
